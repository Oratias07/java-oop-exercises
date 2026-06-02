package graph;

import java.util.Set;
import java.util.HashSet;

/**
 * Checks vertex connectivity in any graph implementing GraphInterface.
 * Uses DFS to determine if two vertices are reachable from each other.
 */
public class ConnectionChecker<V> {
    private GraphInterface<V> g;

    public ConnectionChecker(GraphInterface<V> g) {
        this.g = g;
    }

    /**
     * Checks if v2 is reachable from v1 using depth-first search.
     */
    public boolean check(V v1, V v2) {
        Set<V> visited = new HashSet<>();
        return dfs(v1, v2, visited);
    }

    /**
     * Recursive DFS helper: explores from current vertex to find target.
     * Uses the underlying graph's neighbor method to get adjacent vertices.
     */
    private boolean dfs(V current, V target, Set<V> visited) {
        if (current.equals(target)) return true;
        if (visited.contains(current)) return false;
        visited.add(current);
        // Query graph interface for neighbors and explore recursively
        for (V neighbor : g.neighbours(current)) {
            if (dfs(neighbor, target, visited)) return true;
        }
        return false;
    }
}
