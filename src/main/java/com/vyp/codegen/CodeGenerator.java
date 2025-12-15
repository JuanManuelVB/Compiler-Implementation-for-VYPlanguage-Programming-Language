package com.vyp.codegen;

import java.util.*;

import com.vyp.frontend.ASTVisitor;
import com.vyp.frontend.ast.FunctionDecl;
import com.vyp.frontend.ast.Program;
import com.vyp.frontend.ast.Parameter;
import com.vyp.frontend.ast.expr.BinaryOp;
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


public class CodeGenerator implements ASTVisitor<Void> {

    private final List<String> code = new ArrayList<>();
    private final LabelManager labels = new LabelManager();

    // In a small, human-style code generator we keep a table of string literals
    // and a simple convention for calling and returning. This generator aims
    // to produce easy-to-read VYPcode rather than to be fully optimal.
    private final Map<String,String> stringPool = new LinkedHashMap<>();

    public List<String> generate(Program program) {
        program.accept(this);
        // Emit data (string literals) at the end so they are easy to find.
        if (!stringPool.isEmpty()) {
            code.add(0, "\n; -- data section --");
            for (Map.Entry<String,String> e : stringPool.entrySet()) {
                code.add(1, "DATA " + e.getValue() + ", \"" + e.getKey() + "\"");
            }
            code.add(1, "; -- end data --\n");
        }
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
        // simple prolog: reserve space for locals if needed (omitted here)
        // emit body
        // function body is a BlockStmt
        if (f.getBody() != null) {
            f.getBody().accept(this);
        }

        // implicit return for void functions
        code.add("RETURN [$SP]");
        return null;
    }

    @Override
    public Void visit(com.vyp.frontend.ast.expr.Expression node) {
        // Generic expression visit: nothing to do here because concrete
        // expression nodes implement their own visits. This keeps the
        // implementation explicit and easy to follow.
        return null;
    }

    @Override
    public Void visit(Parameter node) {
        // Parameters are handled at function prolog/semantic phases; the
        // generator doesn't need to emit anything per-parameter here.
        return null;
    }

    @Override
    public Void visit(AssignStmt s) {
        s.getValue().accept(this); // deja el valor en un registro
        code.add("SET " + s.getName() + ", $0");
        return null;
    }

    @Override
    public Void visit(VarDeclStmt s) {
        // For this simple generator we don't emit stack bookkeeping for
        // local declarations; variables are referenced by name in the
        // generated code (SET x, $0 / GET x -> $0). Keep a comment so the
        // emitted VYPcode is readable for humans.
        for (String name : s.getVarNames()) {
            code.add("; local decl " + name + " : " + s.getType());
        }
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
    public Void visit(BlockStmt s) {
        for (var st : s.getStatements()) {
            st.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ExprStmt s) {
        // Evaluate and discard result
        s.getExpr().accept(this);
        return null;
    }

    @Override
    public Void visit(IntLiteral e) {
        code.add("SET $0, " + e.getValue());
        return null;
    }

    @Override
    public Void visit(StringLiteral e) {
        // Deduplicate strings into the data section
        String lit = e.getValue();
        String label = stringPool.get(lit);
        if (label == null) {
            label = "STR" + (stringPool.size() + 1);
            stringPool.put(lit, label);
        }
        code.add("SET $0, " + label);
        return null;
    }

    @Override
    public Void visit(Var e) {
        code.add("SET $0, " + e.getName());
        return null;
    }

    @Override
    public Void visit(FunctionCallExpr e) {
        // Evaluate args left-to-right and push them
        for (var arg : e.getArguments()) {
            arg.accept(this);
            code.add("PUSH $0");
        }
        code.add("CALL " + e.getFunctionName());
        // Assume CALL leaves return value in $0; caller is responsible for
        // cleaning up the stack in a real ABI. For this educational backend
        // we keep it simple and human-friendly.
        return null;
    }

    @Override
    public Void visit(UnaryOp e) {
        e.getExpression().accept(this);
        if (e.getOperator() == UnaryOp.UnaryOperator.NOT) {
            // logical not: assume 0/1 semantics
            code.add("NOT $0, $0");
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
                // Push left and right and call runtime concat
                // Evaluate left/right already done: left is in $1, right in $0
                code.add("PUSH $1");
                code.add("PUSH $0");
                code.add("CALL concat");
                break;
            default:
                // Unknown operator: emit a comment so output stays human-readable
                code.add("; unsupported binary operator " + e.getOperator());
        }
        return null;
    }

    @Override
    public Void visit(IfStmt s) {
        String elseL = labels.fresh();
        String endL = labels.fresh();

        s.getCondition().accept(this); // result in $0
        code.add("JZ $0, " + elseL);

        // then
        s.getIfTrue().accept(this);
        code.add("JMP " + endL);

        // else
        code.add("LABEL " + elseL);
        if (s.getIfFalse() != null) {
            s.getIfFalse().accept(this);
        }

        code.add("LABEL " + endL);
        return null;
    }

    @Override
    public Void visit(WhileStmt s) {
        String start = labels.fresh();
        String end = labels.fresh();
        code.add("LABEL " + start);
        s.getCondition().accept(this);
        code.add("JZ $0, " + end);
        s.getBody().accept(this);
        code.add("JMP " + start);
        code.add("LABEL " + end);
        return null;
    }
}
