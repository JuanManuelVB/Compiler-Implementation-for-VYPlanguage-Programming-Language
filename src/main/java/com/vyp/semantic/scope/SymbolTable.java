
package com.vyp.semantic.scope;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class SymbolTable {

    private SymbolTable parent; // null if global scope, indicates the parent scope (enclosing scope, the one that contains this scope)
    private Map<String, Symbol> symbols = new HashMap<>();//Relation between names and symbols in the current scope

    //Constructor for SymbolTable
    public SymbolTable(SymbolTable parent) {
        this.parent = parent; // null if global scope
    }

    public SymbolTable() {
        this.parent = null; // null if global scope
    }

    /** Method to get enter a new scope (child scope) or exit to the parent scope.
     * When entering a new scope, a new SymbolTable is created with the current one as its parent. 
     * When exiting a scope, the current SymbolTable is set to its parent.
     */
    public void enterScope() {
        SymbolTable child = new SymbolTable(this);
        this.symbols = child.symbols;
        this.parent = child.parent;
    }

    public void exitScope() {
        if (parent != null) {
            this.symbols = parent.symbols;
            this.parent = parent.parent;
        }
    }

    /**
     * Adds a symbol to the current scope.
     * @param sym, the symbol to be added
     * @return true if the symbol was added successfully, false if a symbol with the same name already exists in the current scope.
     */
    public boolean addToScope(Symbol sym) {
        String symbolName = sym.getName();
        if (symbols.containsKey(symbolName)) {
            return false;
        }
        symbols.put(symbolName, sym);
        return true;
    }


    /**
     * Resolves a symbol by its name, searching in the current scope and, if not found, recursively in parent scopes.
     * @param name, the name of the symbol to be resolved
     * @return the Symbol if found, or null if not found
     */
    public Symbol resolve(String name) {
        SymbolTable symbolTable = this;
        while (symbolTable != null) {
            Symbol sym = symbolTable.symbols.get(name);
            if (sym != null) return sym;
            symbolTable = symbolTable.parent;
        }
        return null;
    }

    /**
     * Checks if a symbol with the given name is defined in the current scope.
     * @param symbolName, the name of the symbol to check
     * @return true if the symbol is defined in the current scope, false otherwise
     */
    public boolean isDefined(String symbolName) {
        return symbols.containsKey(symbolName);
    }

    /** 
     * Returns an unmodifiable view of the local entries in the current scope
     * The local entries are the symbols defined in the current scope only, not including parent scopes.
     */
    public Map<String, Symbol> localEntries() {
        return Collections.unmodifiableMap(symbols);
    }
}


