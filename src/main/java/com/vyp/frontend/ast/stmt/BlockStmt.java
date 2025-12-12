package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import java.util.List;
import com.vyp.frontend.ASTVisitor;

public class BlockStmt extends Statement {

    private List<Statement> statements;

    public BlockStmt(List<Statement> statements, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}   