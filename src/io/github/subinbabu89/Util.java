package io.github.subinbabu89;

import java.util.*;

class Util {

    private static Object mock = new Object();

    static List<List<String>> findAllShortestPaths(DigiEvolutionGraph graph, String from, String to) {
        LinkedHashMap<Digimon, Object> queue = new LinkedHashMap<>();
        Set<Digimon> visited = new HashSet<>();
        queue.put(new Digimon(from), mock);

        Digimon nodeTo = null;
        while (queue.keySet().size() > 0) {
            Digimon next = queue.keySet().iterator().next();

            if (next.getKey().equals(to)) {
                // base case: we found the end node and processed all edges to it -> we are done
                nodeTo = next;
                break;
            }

            for (Digimon n : graph.adjacents(next.getKey())) {
                if (!visited.contains(n)) {
                    queue.computeIfAbsent(n, k -> mock);
                    n.addParent(next);
                }
            }

            // removing the node from queue
            queue.remove(next);
            visited.add(next);
        }
        if (nodeTo == null) {
            throw new IllegalStateException();
        }

        // Now performing the dfs from target node to gather all paths
        List<List<String>> result = new ArrayList<>();
        dfs(nodeTo, result, new LinkedList<>());

        return result;
    }

    private static void dfs(Digimon n, List<List<String>> result, LinkedList<String> path) {
        path.addFirst(n.getKey());
        if (n.getParents().size() == 0) {
            // base case: we came to target vertex
            result.add(new ArrayList<>(path));
        }
        for (Digimon p : n.getParents()) {
            dfs(p, result, path);
        }
        // do not forget to remove the processed element from path
        path.removeFirst();
    }
}
