
package com.vyp.semantic.scope;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class SymbolTable {
    private SymbolTable parent;
    private Map<String, Symbol> symbols = new HashMap<>();

    public SymbolTable(SymbolTable parent) {
        this.parent = parent; // null if global scope
    }

    public SymbolTable() {
        this.parent = null; // null if global scope
    }

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

    public boolean addToScope(Symbol sym) {
        String symbolName = sym.getName();
        if (symbols.containsKey(symbolName)) {
            return false;
        }
        symbols.put(symbolName, sym);
        return true;
    }

    public Symbol resolve(String name) {
        SymbolTable symbolTable = this;
        while (symbolTable != null) {
            Symbol sym = symbolTable.symbols.get(name);
            if (sym != null) return sym;
            symbolTable = symbolTable.parent;
        }
        return null;
    }

    public boolean isDefined(String symbolName) {
        return symbols.containsKey(symbolName);
    }


    public Map<String, Symbol> localEntries() {
        return Collections.unmodifiableMap(symbols);
    }
}


