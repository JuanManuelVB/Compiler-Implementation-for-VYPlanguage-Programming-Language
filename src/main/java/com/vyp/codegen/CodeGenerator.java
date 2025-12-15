package com.vyp.codegen;

import java.beans.Expression;
import java.util.*;

import com.vyp.frontend.ASTVisitor;
import com.vyp.frontend.ast.FunctionDecl;
import com.vyp.frontend.ast.Program;
import com.vyp.frontend.ast.expr.BinaryOp;
import com.vyp.frontend.ast.expr.IntLiteral;
import com.vyp.frontend.ast.expr.StringLiteral;
import com.vyp.frontend.ast.expr.Var;
import com.vyp.frontend.ast.stmt.AssignStmt;
import com.vyp.frontend.ast.stmt.BlockStmt;
import com.vyp.frontend.ast.stmt.ReturnStmt;

/**
 * VYPa – Code Generator (versión mínima y humana)
 * Genera VYPcode directamente desde el AST usando Visitor.
 */
public class CodeGenerator implements ASTVisitor<Void> {

    private final List<String> code = new ArrayList<>();

    public List<String> generate(Program program) {
        program.accept(this);
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

        for (BlockStmt s : f.getBody()) {
            s.accept(this);
        }

        // retorno implícito para void
        code.add("RETURN [$SP]");
        return null;
    }

    @Override
    public Void visit(AssignStmt s) {
        s.getValue().accept(this); // deja el valor en un registro
        code.add("SET " + s.getName() + ", $0");
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
    public Void visit(StringLiteral e) {
        code.add("SET $0, \"" + e.getValue() + "\"");
        return null;
    }

    @Override
    public Void visit(Var e) {
        code.add("SET $0, " + e.getName());
        return null;
    }

    @Override
    public Void visit(BinaryOp e) {
        e.getLeft().accept(this);
        code.add("SET $1, $0");
        e.getRight().accept(this);

        if( e.getOperator().equals(BinaryOp.BinaryOperator.ADD)){
           code.add("ADDI $0, $1, $0");
        }else if ( e.getOperator().equals(BinaryOp.BinaryOperator.SUB)){
           code.add("SUBI $0, $1, $0");
        }else if ( e.getOperator().equals(BinaryOp.BinaryOperator.MUL)){
           code.add("MULI $0, $1, $0");
        }else if ( e.getOperator().equals(BinaryOp.BinaryOperator.DIV)) {
           code.add("DIVI $0, $1, $0");
        }
        return null;
    }
}
