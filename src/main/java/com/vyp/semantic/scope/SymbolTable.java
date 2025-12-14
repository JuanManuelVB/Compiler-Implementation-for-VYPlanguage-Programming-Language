
package com.vyp.semantic.scope;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.vyp.frontend.ast.SourceLocation;

public class SymbolTable implements Scope {
    private final String name;
    private final Scope parent;
    private final Map<String, Symbol> symbols = new HashMap<>();

    public SymbolTable(String name, Scope parent) {
        this.name = name;
        this.parent = parent; // null si es el scope global
    }

    public SymbolTable(String name) {
        this(name, null);
    }

    @Override
    public String getScopeName() {
        return name;
    }

    @Override
    public Scope getEnclosingScope() {
        return parent;
    }

    @Override
    public void define(Symbol sym) {
        String symbolName = sym.getName();
        if (symbols.containsKey(symbolName)) {
            throw new DuplicateSymbolException(
                "Ya existe un símbolo con ese nombre en este scope: " + symbolName, sym.getLocation());
        }
        symbols.put(symbolName, sym);
    }

    @Override
    public Optional<Symbol> resolve(String symbolName) {
        Symbol sym = symbols.get(symbolName);
        if (sym != null) return Optional.of(sym);
        if (parent != null) return parent.resolve(symbolName);
        return Optional.empty();
    }

    @Override
    public boolean isDefined(String symbolName) {
        return symbols.containsKey(symbolName);
    }

    @Override
    public Map<String, Symbol> entries() {
        return Collections.unmodifiableMap(symbols);
    }
}

/**
 * Exception for local duplicates; SemanticAnalyzer should catch it
 */
class DuplicateSymbolException extends RuntimeException {
    private final SourceLocation loc;

    public DuplicateSymbolException(String msg, SourceLocation location) {
        super(msg);
        this.loc = location;
    }

    public SourceLocation getLocation() {
        return loc;
    }
}
