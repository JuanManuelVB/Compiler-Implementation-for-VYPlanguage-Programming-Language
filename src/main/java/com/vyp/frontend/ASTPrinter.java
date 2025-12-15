package com.vyp.frontend;

import com.vyp.frontend.ast.Program;
import com.vyp.frontend.ast.FunctionDecl;
import com.vyp.frontend.ast.Parameter;
import com.vyp.frontend.ast.expr.*;
import com.vyp.frontend.ast.stmt.*;

//Class that prints our syntax tree in a human format. Used for debugging purposes.
public class ASTPrinter implements ASTVisitor<Void> {

    private int level = 0;//the current indentation level

    // Helper methods for printing with the desired indentation
    private void println(String s) {
        for (int i = 0; i < level; i++)
            System.out.print("  ");
        System.out.println(s);
    }

    /**Increase the level of indentation */
    private void inc() {
        level++;
    }

    /** Decrease the level of indentation */
    private void dec() {
        if (level > 0)
            level--;
    }

    //Redefinition of visit methods for each element in the syntax tree, so that they print their content in a human-readable format.
    //They are Void because they do not return any value, but must be a type T.
    @Override
    public Void visit(Program node) {
        println("Program");
        inc();
        for (FunctionDecl f : node.getFunctions()) {
            f.accept(this);
        }
        dec();
        return null;
    }

    @Override
    public Void visit(FunctionDecl node) {
        println("FunctionDecl: " + node.getName() + " -> "
                + (node.getReturnType() != null ? node.getReturnType().getBasicType() : "?"));
                //ternary operator: condition ? value_if_true : value_if_false
        inc();
        println("Params:");
        inc();
        for (Parameter p : node.getParams())
            p.accept(this);
        dec();
        println("Body:");
        inc();
        node.getBody().accept(this);
        dec();
        dec();
        return null;
    }

    @Override
    public Void visit(Parameter node) {
        node.accept(this);
        println("Param: " + node.getName() + "- " + (node.getType() != null ? node.getType().getBasicType() : "?"));
        return null;
    }

    @Override
    public Void visit(Expression node) {
        node.accept(this);
        println("Expression: " + node.getType().getBasicType());
        return null;
    }

    @Override
    public Void visit(IntLiteral node) {
        node.accept(this);
        println("IntLiteral: " + node.getValue());
        return null;
    }

    @Override
    public Void visit(StringLiteral node) {
        node.accept(this);
        println("StringLiteral: \'" + node.getValue() + "\'");
        return null;
    }

    @Override
    public Void visit(Var node) {
        node.accept(this);
        println("VarRef: " + node.getName());
        return null;
    }

    @Override
    public Void visit(BinaryOp node) {
        println("BinaryOp: " + node.getOperator());
        inc();
        node.getLeft().accept(this);
        node.getRight().accept(this);
        dec();
        return null;
    }

    @Override
    public Void visit(UnaryOp node) {
        println("UnaryOp: " + node.getOperator());
        inc();
        node.getExpression().accept(this);
        dec();
        return null;
    }

    @Override
    public Void visit(FunctionCallExpr node) {
        println("Call: " + node.getFunctionName());
        inc();
        for (Expression e : node.getArguments())
            e.accept(this);
        dec();
        return null;
    }

    @Override
    public Void visit(BlockStmt node) {
        println("Block");
        inc();
        for (Statement s : node.getStatements())
            s.accept(this);
        dec();
        return null;
    }

    @Override
    public Void visit(VarDeclStmt node) {
        println("VarDecl: " + node.getType().getBasicType() + " " + node.getVarNames());
        node.accept(this);
        return null;
    }

    @Override
    public Void visit(AssignStmt node) {
        println("Assign: " + node.getName());
        inc();
        node.getValue().accept(this);
        dec();
        return null;
    }

    @Override
    public Void visit(IfStmt node) {
        println("If");
        inc();
        println("Cond:");
        inc();
        node.getCondition().accept(this);
        dec();
        println("Then:");
        inc();
        node.getIfTrue().accept(this);
        dec();
        if (node.getIfFalse() != null) {
            println("Else:");
            inc();
            node.getIfFalse().accept(this);
            dec();
        }
        dec();
        return null;
    }

    @Override
    public Void visit(WhileStmt node) {
        println("While");
        inc();
        println("Cond:");
        inc();
        node.getCondition().accept(this);
        dec();
        println("Body:");
        inc();
        node.getBody().accept(this);
        dec();
        dec();
        return null;
    }

    @Override
    public Void visit(ReturnStmt node) {
        println("Return");
        if (node.getValue() != null) {
            inc();
            node.getValue().accept(this);
            dec();
        }
        return null;
    }

    @Override
    public Void visit(ExprStmt node) {
        println("ExprStmt");
        inc();
        node.getExpr().accept(this);
        dec();
        return null;
    }

}
