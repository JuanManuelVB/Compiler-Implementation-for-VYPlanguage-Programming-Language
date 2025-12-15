package com.vyp.frontend;

import com.vyp.frontend.ast.FunctionDecl;
import com.vyp.frontend.ast.Program;
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
import com.vyp.frontend.ast.stmt.VarDeclStmt;
import com.vyp.frontend.ast.stmt.WhileStmt;
import com.vyp.frontend.ast.Parameter;

// (Visitor design pattern is a way of separating an algorithm from an object structure on which it operates,
// and it allows adding new operations to existing object structures without modifying those structures. */
// One visit method must be defined for each concrete AST node class.
public interface ASTVisitor<T> {

    // Program
    T visit(Program node);
    T visit(FunctionDecl node);
    T visit (Parameter node);

    // Expressions
    T visit(Expression node);
    T visit(IntLiteral node);
    T visit(StringLiteral node);
    T visit(Var node);
    T visit(BinaryOp node);
    T visit(UnaryOp node);
    T visit(FunctionCallExpr node);

    // Statements
    T visit(BlockStmt node);
    T visit(VarDeclStmt node);
    T visit(AssignStmt node);
    T visit(IfStmt node);
    T visit(WhileStmt node);
    T visit(ReturnStmt node);
    T visit(ExprStmt node);


}

