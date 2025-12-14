package com.vyp.semantic.scope;

import com.vyp.semantic.symbol.Symbol;
import java.util.Map;
import java.util.Optional;

public interface Scope {
    /** Nombre del scope (por ejemplo: "global", nombre de función, etc.) */
    String getScopeName();

    /** Scope que envuelve a este (puede ser null para el scope global) */
    Scope getEnclosingScope();

    /** Añade/define un símbolo en este scope */
    void define(Symbol sym);

    /** Resuelve un símbolo por nombre. Busca en este scope y, si no está, en los scopes envolventes */
    Optional<Symbol> resolve(String name);

    /** Comprueba si un símbolo está definido en este scope (solo en este, no recursivo) */
    boolean isDefined(String name);

    /** Devuelve las entradas locales del scope como un mapa (nombre -> símbolo) */
    Map<String, Symbol> entries();
}
