package com.vyp.frontend.ast.stmt;
import com.vyp.frontend.ast.SourceLocation;
import java.util.List;

public class BlockStmt extends Stmt {
    // Skeleton: block statement removed

    private List<Stmt> statements;

    public BlockStmt(List<Stmt> statements, SourceLocation sourceLocation) {
        super(sourceLocation);
        this.statements = statements;
    }

    public List<Stmt> getStatements() {
        return statements;
    }
}   