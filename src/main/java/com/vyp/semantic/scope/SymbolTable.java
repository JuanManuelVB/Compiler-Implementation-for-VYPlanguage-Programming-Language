
package com.vyp.semantic.scope;

import com.vyp.semantic.symbol.Symbol;
import com.vyp.util.Position;

import java.util.*;

/** Scope enlazado (bloque o función). */
public class SymbolTable implements Scope {
    private final String scopeName;
    private final Scope enclosingScope;
    private final Map<String, Symbol> symbols = new LinkedHashMap<>();

    public SymbolTable(String scopeName, Scope enclosingScope) {
        this.scopeName = Objects.requireNonNull(scopeName);
        this.enclosingScope = enclosingScope; // puede ser null (global)
    }

    public SymbolTable(String scopeName) {
        this(scopeName, null);
    }

    @Override
    public String getScopeName() { return scopeName; }

    @Override
    public Scope getEnclosingScope() { return enclosingScope; }

    /** Define símbolo en este scope; si ya existe localmente, lanza excepción para que el caller reporte error 14. */
    @Override
    public void define(Symbol sym) {
        String name = sym.getName();
        if (symbols.containsKey(name)) {
            throw new DuplicateSymbolException(
                "Redefinición en el mismo ámbito '" + scopeName + "': " + name,
                sym.getPosition() // asegura que Symbol tiene Position
            );
        }
        symbols.put(name, sym);
    }

    /** Resolución desde este scope hacia los padres. Nunca retorna null: usa Optional. */
    @Override
    public Optional<Symbol> resolve(String name) {
        for (Scope s = this; s != null; s = s.getEnclosingScope()) {
            if (s.isDefined(name)) {
                return Optional.of(s.entries().get(name));
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean isDefined(String name) { return symbols.containsKey(name); }

    /** Vista inmutable para debugging/inspección. */
    @Override
    public Map<String, Symbol> entries() { return Collections.unmodifiableMap(symbols); }
}

/** Excepción para duplicidades locales; el SemanticAnalyzer debe atraparla y reportar exit code 14. */
class DuplicateSymbolException extends RuntimeException {
    private final Position pos;
    public DuplicateSymbolException(String msg, Position pos) { super(msg); this.pos = pos; }
    public Position getPosition() { return pos; }
}
