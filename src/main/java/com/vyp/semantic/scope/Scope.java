package com.vyp.semantic.scope;

import com.vyp.semantic.symbol.Symbol;
import java.util.Optional;

public interface Scope {
    void define(Symbol symbol);
    Optional<Symbol> resolve(String name);
}
