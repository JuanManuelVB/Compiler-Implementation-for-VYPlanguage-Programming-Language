package com.vyp.semantic.scope;

import com.vyp.semantic.symbol.Symbol;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SymbolTable implements Scope {
    private final Map<String, Symbol> symbols = new HashMap<>();

    @Override
    public void define(Symbol symbol) { symbols.put(symbol.getName(), symbol); }

    @Override
    public Optional<Symbol> resolve(String name) { return Optional.ofNullable(symbols.get(name)); }
}
