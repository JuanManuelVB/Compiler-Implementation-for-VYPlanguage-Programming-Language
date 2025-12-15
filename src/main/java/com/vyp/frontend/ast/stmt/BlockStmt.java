package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import java.util.List;
import com.vyp.frontend.ASTVisitor;

public class BlockStmt extends Statement {

    private List<Statement> statements;//the list of statements in the block

     /** Constructor for BlockStmt */
    public BlockStmt(List<Statement> statements, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.statements = statements;
    }

    /** Getter and Setter for statements */
    public List<Statement> getStatements() {
        return statements;
    }

    /** Method to add statements to the block */
    public void addStatements(List<Statement> statements) {
        for (Statement stmt : statements) {
            this.statements.add(stmt);
        }
    }

    /** Method accept redefined */
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}   