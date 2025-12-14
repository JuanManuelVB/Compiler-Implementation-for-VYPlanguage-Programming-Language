package com.vyp.semantic;

import com.vyp.frontend.ast.*;
import com.vyp.frontend.ast.expr.*;
import com.vyp.frontend.ast.stmt.*;
import com.vyp.semantic.scope.SymbolTable;
import com.vyp.semantic.scope.*;
import com.vyp.semantic.type.*;
import com.vyp.util.ErrorReporter;

public class SemanticAnalyzer implements ASTVisitor<Type> {

    private SymbolTable table = new SymbolTable();
    private ErrorReporter errors;

    private FunctionSymbol currentFunction = null;

    public SemanticAnalyzer(ErrorReporter errors) {
        this.errors = errors;
    }

    /* ================= PROGRAM ================= */

    @Override
    public Type visit(Program p) {

        // 1. Registrar funciones
        for (FunctionDecl f : p.getFunctions()) {
            if (!table.defineFunction(
                    new FunctionSymbol(f.getName(), f.getReturnType(), f.getParams()))) {
                errors.error(f.getLocation(),
                        "Function already defined: " + f.getName());
            }
        }

        // 2. Comprobar main
        FunctionSymbol main = table.resolveFunction("main");
        if (main == null || !main.getReturnType().equals(IntType.INSTANCE)) {
            errors.error(p.getLocation(),
                    "Program must define: int main()");
        }

        // 3. Analizar cuerpos
        for (FunctionDecl f : p.getFunctions()) {
            f.accept(this);
        }

        return VoidType.INSTANCE;
    }

    /* ================= FUNCTION ================= */

    @Override
    public Type visit(FunctionDecl f) {

        currentFunction = table.resolveFunction(f.getName());
        table.enterScope();

        // parámetros
        for (Param p : f.getParams()) {
            if (!table.define(new VariableSymbol(p.getName(), p.getType()))) {
                errors.error(p.getLocation(),
                        "Duplicate parameter: " + p.getName());
            }
        }

        f.getBody().accept(this);

        table.exitScope();
        currentFunction = null;
        return VoidType.INSTANCE;
    }

    /* ================= BLOCK ================= */

    @Override
    public Type visit(BlockStmt b) {
        table.enterScope();
        for (Stmt s : b.getStatements()) {
            s.accept(this);
        }
        table.exitScope();
        return VoidType.INSTANCE;
    }

    /* ================= STATEMENTS ================= */

    @Override
    public Type visit(VarDeclStmt s) {
        for (String name : s.getNames()) {
            if (!table.define(new VariableSymbol(name, s.getType()))) {
                errors.error(s.getLocation(),
                        "Variable already declared: " + name);
            }
        }
        return VoidType.INSTANCE;
    }

    @Override
    public Type visit(AssignStmt s) {
        Symbol sym = table.resolve(s.getName());
        if (sym == null) {
            errors.error(s.getLocation(),
                    "Variable not declared: " + s.getName());
            return IntType.INSTANCE;
        }

        Type exprType = s.getExpr().accept(this);
        if (!sym.getType().equals(exprType)) {
            errors.error(s.getLocation(),
                    "Type mismatch in assignment to " + s.getName());
        }

        return VoidType.INSTANCE;
    }

    @Override
    public Type visit(ReturnStmt s) {
        Type ret = (s.getExpr() == null)
                ? VoidType.INSTANCE
                : s.getExpr().accept(this);

        if (!ret.equals(currentFunction.getReturnType())) {
            errors.error(s.getLocation(),
                    "Wrong return type in function " + currentFunction.getName());
        }
        return VoidType.INSTANCE;
    }

    @Override
    public Type visit(IfStmt s) {
        if (!s.getCondition().accept(this).equals(IntType.INSTANCE)) {
            errors.error(s.getLocation(),
                    "If condition must be int");
        }
        s.getThenBlock().accept(this);
        if (s.getElseBlock() != null)
            s.getElseBlock().accept(this);
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

    /* ================= EXPRESSIONS ================= */

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
        if (sym == null) {
            errors.error(e.getLocation(),
                    "Variable not declared: " + e.getName());
            return IntType.INSTANCE;
        }
        return sym.getType();
    }

    @Override
    public Type visit(FunctionCallExpr e) {
        FunctionSymbol f = table.resolveFunction(e.getName());
        if (f == null) {
            errors.error(e.getLocation(),
                    "Function not declared: " + e.getName());
            return IntType.INSTANCE;
        }

        if (f.getParams().size() != e.getArgs().size()) {
            errors.error(e.getLocation(),
                    "Wrong number of arguments in call to " + e.getName());
        }

        for (int i = 0; i < Math.min(f.getParams().size(), e.getArgs().size()); i++) {
            Type expected = f.getParams().get(i).getType();
            Type actual = e.getArgs().get(i).accept(this);
            if (!expected.equals(actual)) {
                errors.error(e.getArgs().get(i).getLocation(),
                        "Argument type mismatch");
            }
        }

        return f.getReturnType();
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

    @Override
    public Type visit(UnaryOp e) {
        return e.getExpr().accept(this);
    }
}
