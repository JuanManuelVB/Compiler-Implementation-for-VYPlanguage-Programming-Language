package com.vyp.semantic.scope;

import java.util.Map;
import java.util.Optional;

public interface Scope {
    /** Names the scope(function name, global, subfuction, ...) */
    String getScopeName();

    /** Scope that encloses the one defining (null if global scope) */
    Scope getEnclosingScope();

    /** Adds a symbol to the scope (defines it) */
    void addToScope(Symbol sym);

    /** Resolves the symbol by name. Searches in the scope, and if not found, in enclosing scopes */
    Optional<Symbol> resolve(String name);

    /**Checks if a symbol is defined in the scope (no enclosing ones) */
    boolean isDefined(String name);

    /**Returns the local entries of the scope as a Map(name --> symbol)*/
    Map<String, Symbol> localEntries();
}
