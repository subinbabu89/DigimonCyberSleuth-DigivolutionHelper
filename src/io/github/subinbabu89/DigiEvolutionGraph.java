package io.github.subinbabu89;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

class DigiEvolutionGraph {
    private Map<String, Set<Digimon>> adjacencyList = new HashMap<>();

    void add(String from, String to) {
        addEdge(to, from);
        addEdge(from, to);
    }

    private void addEdge(String from, String to) {
        Set<Digimon> list = adjacencyList.computeIfAbsent(from, k -> new LinkedHashSet<>());
        list.add(Digimon.get(to));
    }

    Set<Digimon> adjacents(String v) {
        return adjacencyList.get(v);
    }
}
