package com.vyp.semantic;

import java.util.ArrayList;
import java.util.List;

import com.vyp.frontend.ASTVisitor;
import com.vyp.frontend.ast.*;
import com.vyp.frontend.ast.expr.*;
import com.vyp.frontend.ast.stmt.*;
import com.vyp.semantic.scope.Symbol;
import com.vyp.semantic.scope.Symbol.Kind;
import com.vyp.semantic.scope.SymbolTable;
import com.vyp.semantic.type.*;
import com.vyp.util.ErrorReporter;

public class SemanticAnalyzer implements ASTVisitor<Type> {

    private SymbolTable table = new SymbolTable();
    private ErrorReporter errors;

    private Symbol currentFunction = null;

    public SemanticAnalyzer(ErrorReporter errors) {
        this.errors = errors;
        this.currentFunction.setKind(Symbol.Kind.FUNCTION);
    }

    /* PROGRAM */
    @Override
    public Type visit(Program p) {

        // 1. Register functions
        for (FunctionDecl f : p.getFunctions()) {

            List<Type> ParameterTypes = new ArrayList<>();
            for (Parameter param : f.getParams()) {
                ParameterTypes.add(param.getType());
            }

            Symbol fun = Symbol.function(
                    f.getName(),
                    f.getReturnType(),
                    ParameterTypes,
                    f.getLocation());

            if (!table.addToScope(fun)) {
                errors.error(f.getLocation(),
                        "Function already addToScoped: " + f.getName());
            }
        }

        // 2. Checks for main function
        Symbol main = table.resolve("main");
        if (main == null
                || main.getKind() != Symbol.Kind.FUNCTION
                || !main.getType().equals(IntType.INSTANCE)) {

            errors.error(p.getLocation(),
                    "Program must addToScope: int main()");
        }

        // 3. Analyze function bodies
        for (FunctionDecl f : p.getFunctions()) {
            f.accept(this);
        }

        return VoidType.INSTANCE;
    }

    /* FUNCTION */
    @Override
    public Type visit(FunctionDecl f) {

        currentFunction = table.resolve(f.getName());
        table.enterScope();

        // parámetros
        for (Parameter p : f.getParams()) {
            Symbol var = Symbol.variable(
                    p.getName(),
                    p.getType(),
                    p.getLocation());

            if (!table.addToScope(var)) {
                errors.error(p.getLocation(),
                        "Duplicate Parametereter: " + p.getName());
            }
        }

        f.getBody().accept(this);

        table.exitScope();
        currentFunction = null;
        return VoidType.INSTANCE;
    }

    /* BLOCK */

    public Type visit(BlockStmt b) {
        table.enterScope();
        for (Statement s : b.getStatements()) {
            s.accept(this);
        }
        table.exitScope();
        return VoidType.INSTANCE;
    }

    /* STATEMENTS */
    @Override
    public Type visit(VarDeclStmt s) {
        for (String name : s.getVarNames()) {
            Symbol var = Symbol.variable(
                    name,
                    s.getType(),
                    s.getLocation());

            if (!table.addToScope(var)) {
                errors.error(s.getLocation(),
                        "Variable already declared: " + name);
            }
        }
        return VoidType.INSTANCE;
    }
    @Override
    public Type visit(AssignStmt s) {
        Symbol sym = table.resolve(s.getName());

        if (sym == null || sym.getKind() != Kind.VARIABLE) {
            errors.error(s.getLocation(),
                    "Variable not declared: " + s.getName());
            return IntType.INSTANCE;
        }

        Type rhs = s.getValue().accept(this);
        if (!sym.getType().equals(rhs)) {
            errors.error(s.getLocation(),
                    "Type mismatch in assignment to " + s.getName());
        }

        return VoidType.INSTANCE;
    }

    @Override
    public Type visit(ReturnStmt s) {
        Type ret = (s.getValue() == null)
                ? VoidType.INSTANCE
                : s.getValue().accept(this);

        if (!ret.equals(currentFunction.getType())) {
            errors.error(s.getLocation(),
                    "Wrong return type in function " +
                            currentFunction.getName());
        }
        return VoidType.INSTANCE;
    }

    @Override
    public Type visit(IfStmt s) {
        if (!s.getCondition().accept(this).equals(IntType.INSTANCE)) {
            errors.error(s.getLocation(),
                    "If condition must be int");
        }
        s.getIfTrue().accept(this);
        if (s.getIfFalse() != null)
            s.getIfFalse().accept(this);
        return VoidType.INSTANCE;
    }

    @Override
    public Type visit(WhileStmt s) {
        if (!s.getCondition().accept(this).equals(IntType.INSTANCE)) {
            errors.error(s.getLocation(),
                    "While condition must be int");
        }
        s.getBody().accept(this);
        return VoidType.INSTANCE;
    }

    @Override
    public Type visit(ExprStmt s) {
        s.getExpr().accept(this);
        return VoidType.INSTANCE;
    }

    /* EXPRESSIONS */
    @Override
    public Type visit(IntLiteral e) {
        return IntType.INSTANCE;
    }

    @Override
    public Type visit(StringLiteral e) {
        return StringType.INSTANCE;
    }

    @Override
    public Type visit(Var e) {
        Symbol sym = table.resolve(e.getName());
        if (sym == null || sym.getKind() != Symbol.Kind.VARIABLE) {
            errors.error(e.getLocation(),
                    "Variable not declared: " + e.getName());
            return IntType.INSTANCE;
        }
        return sym.getType();
    }

    @Override
    public Type visit(FunctionCallExpr e) {
        Symbol fun = table.resolve(e.getFunctionName());

        if (fun == null || fun.getKind() != Symbol.Kind.FUNCTION) {
            errors.error(e.getLocation(),
                    "Function not declared: " + e.getFunctionName());
            return IntType.INSTANCE;
        }

        if (fun.getParamTypes().size() != e.getArguments().size()) {
            errors.error(e.getLocation(),
                    "Wrong number of arguments in call to " + e.getFunctionName());
        }

        for (int i = 0; i < Math.min(fun.getParamTypes().size(), e.getArguments().size()); i++) {

            Type expected = fun.getParamTypes().get(i);
            Type actual = e.getArguments().get(i).accept(this);

            if (!expected.equals(actual)) {
                errors.error(e.getArguments().get(i).getLocation(),
                        "Argument type mismatch");
            }
        }

        return fun.getType(); // return type
    }

    @Override
    public Type visit(BinaryOp e) {
        Type l = e.getLeft().accept(this);
        Type r = e.getRight().accept(this);

        if (!l.equals(r)) {
            errors.error(e.getLocation(),
                    "Binary operands must have same type");
        }
        return l;
    }

    public Type visit(UnaryOp e) {
        return e.getExpression().accept(this);
    }

    @Override
    public Type visit(Parameter node) {
        // The type of a parameter is simply its declared type
        return node.getType();
    }

    @Override
    public Type visit(Expression node) {
        // Dispatch to the concrete expression visitor based on runtime type.
        if (node instanceof IntLiteral) return visit((IntLiteral) node);
        if (node instanceof StringLiteral) return visit((StringLiteral) node);
        if (node instanceof Var) return visit((Var) node);
        if (node instanceof BinaryOp) return visit((BinaryOp) node);
        if (node instanceof UnaryOp) return visit((UnaryOp) node);
        if (node instanceof FunctionCallExpr) return visit((FunctionCallExpr) node);

        // Unknown expression kind: report and return error type
        errors.error(node.getLocation(), "Unsupported expression node: " + node.getClass().getSimpleName());
        return ErrorType.INSTANCE;
    }
    

}