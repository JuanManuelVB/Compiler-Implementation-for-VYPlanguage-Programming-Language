package com.vyp.codegen;

import java.util.*;

import com.vyp.frontend.ASTVisitor;
import com.vyp.frontend.ast.FunctionDecl;
import com.vyp.frontend.ast.Program;
import com.vyp.frontend.ast.Parameter;
import com.vyp.frontend.ast.expr.BinaryOp;
import com.vyp.frontend.ast.expr.Expression;
import com.vyp.frontend.ast.expr.FunctionCallExpr;
import com.vyp.frontend.ast.expr.IntLiteral;
import com.vyp.frontend.ast.expr.StringLiteral;
import com.vyp.frontend.ast.expr.UnaryOp;
import com.vyp.frontend.ast.expr.Var;
import com.vyp.frontend.ast.stmt.AssignStmt;
import com.vyp.frontend.ast.stmt.BlockStmt;
import com.vyp.frontend.ast.stmt.ExprStmt;
import com.vyp.frontend.ast.stmt.IfStmt;
import com.vyp.frontend.ast.stmt.ReturnStmt;
import com.vyp.frontend.ast.stmt.Statement;
import com.vyp.frontend.ast.stmt.VarDeclStmt;
import com.vyp.frontend.ast.stmt.WhileStmt;
import com.vyp.util.ErrorReporter;

// A simple code generator that produces VYPcode from the AST
public class CodeGenerator implements ASTVisitor<Void> {

    private final List<String> code = new ArrayList<>();

    // simple label manager 
    private int labelCounter = 0;

    private String newLabel() {
        return "L" + (labelCounter++);
    }

    public List<String> generate(Program p) {
        p.accept(this);
        return code;
    }
    
    @Override
    public Void visit(Program program) {
        for (FunctionDecl f : program.getFunctions()) {
            f.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDecl f) {
        code.add("LABEL " + f.getName());
        f.getBody().accept(this);
        code.add("RETURN");
        return null;
    }

    @Override
    public Void visit(BlockStmt b) {
        for (Statement s : b.getStatements()) {
            s.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(VarDeclStmt s) {
        for (String name : s.getVarNames()) {
            code.add("; local var " + name + " : " + s.getType());
        }
        return null;
    }

    @Override
    public Void visit(AssignStmt s) {
        s.getValue().accept(this); // sets the value in $0
        code.add("SET " + s.getName() + ", $0");
        return null;
    }

    @Override
    public Void visit(ExprStmt s) {
        s.getExpr().accept(this);   // Evaluate and discard result
        return null;
    }

     @Override
    public Void visit(ReturnStmt s) {
        if (s.getValue() != null) {
            s.getValue().accept(this);
        }
        code.add("RETURN [$SP]");
        return null;
    }

    @Override
    public Void visit(IntLiteral e) {
        code.add("SET $0, " + e.getValue());
        return null;
    }

    @Override
    public Void visit(StringLiteral s) {
    code.add("SET $0, \"" + s.getValue() + "\"");
    return null;
}


    @Override
    public Void visit(IfStmt s) {
        String elseL = newLabel();
        String endL = newLabel();

        s.getCondition().accept(this); // result in $0
        code.add("JUMPZ $0, " + elseL); 

        s.getIfTrue().accept(this);
        code.add("JUMP " + endL);

        code.add("LABEL " + elseL);
        if (s.getIfFalse() != null) {
            s.getIfFalse().accept(this);
        }

        code.add("LABEL " + endL);
        return null;
    }

    @Override
    public Void visit(WhileStmt s) {
        String start = newLabel();
        String end = newLabel();

        code.add("LABEL " + start);
        s.getCondition().accept(this);
        code.add("JUMPZ $0, " + end);

        s.getBody().accept(this);
        code.add("JUMP " + start);
        code.add("LABEL " + end);
        return null;
    }

    

    @Override
    public Void visit(Var e) {
        code.add("SET $0, " + e.getName());
        return null;
    }

    @Override
    public Void visit(FunctionCallExpr e) {
        // Evaluate args left-to-right and store in registers
        for (Expression arg : e.getArguments()) {
            arg.accept(this); 
        }
        code.add("CALL [$SP], " + e.getFunctionName());
        return null;
    }

    @Override
    public Void visit(UnaryOp e) {
        e.getExpression().accept(this);
        switch (e.getOperator()) {
            case NOT:
                // logical not: assume 0/1 semantics
                code.add("NOT $0, $0");
                break;
            case PLUS:
                // unary plus: no-op
                break;
            case MINUS:
                // unary minus: $0 = 0 - $0
                code.add("SET $1, 0");
                code.add("SUBI $0, $1, $0");
                break;
            default:
                break;
        }
        return null;
    } 

    @Override
    public Void visit(BinaryOp e) {
        e.getLeft().accept(this);
        code.add("SET $1, $0");
        e.getRight().accept(this);
        switch (e.getOperator()) {
            case ADD:
                code.add("ADDI $0, $1, $0");
                break;
            case SUB:
                code.add("SUBI $0, $1, $0");
                break;
            case MUL:
                code.add("MULI $0, $1, $0");
                break;
            case DIV:
                code.add("DIVI $0, $1, $0");
                break;
            case LT:
                code.add("LTI $0, $1, $0");
                break;
            case GT:
                code.add("GTI $0, $1, $0");
                break;
            case EQ:
                code.add("EQI $0, $1, $0");
                break;
            case LTE:
                // left <= right  -> (left < right) OR (left == right)
                code.add("LTI $2, $1, $0");
                code.add("EQI $1, $1, $0");
                code.add("OR $0, $2, $1");
                break;
            case GTE:
                // left >= right -> (left > right) OR (left == right)
                code.add("GTI $2, $1, $0");
                code.add("EQI $1, $1, $0");
                code.add("OR $0, $2, $1");
                break;
            case NEQ:
                // not equal -> not (left == right)
                code.add("EQI $1, $1, $0");
                code.add("NOT $0, $1");
                break;
            case AND:
                code.add("AND $0, $1, $0");
                break;
            case OR:
                code.add("OR $0, $1, $0");
                break;
            case CONCAT:
                code.add("CALL [$SP], concat");
                break;
            default:
                code.add("; unsupported binary operator " + e.getOperator());
                throw new ErrorReporter.CompilerException(null, null, labelCounter);
        }
        return null;
    }

    @Override
    public Void visit(Expression node) {
        return null;
    }

    @Override
    public Void visit(Parameter node) {
        return null;
    }

   
}
