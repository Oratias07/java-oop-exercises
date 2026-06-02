package graph;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Undirected graph implementation supporting vertex and edge operations,
 * with connectivity checking via depth-first search (DFS).
 */
public class Graph<V> {
    private Set<V> vertices;
    private Map<V, Set<V>> edges;

    public Graph() {
        vertices = new HashSet<>();
        edges = new HashMap<>();
    }

    public void addVertex(V v) throws GraphException {
        if (vertices.contains(v)) throw new GraphException("Vertex already exists: " + v);
        vertices.add(v);
        edges.put(v, new HashSet<>());
    }

    public void addEdge(V v1, V v2) throws GraphException {
        if (!vertices.contains(v1) || !vertices.contains(v2))
            throw new GraphException("One or both vertices don't exist");
        if (edges.get(v1).contains(v2))
            throw new GraphException("Edge already exists");
        edges.get(v1).add(v2);
        edges.get(v2).add(v1);
    }

    public boolean hasEdge(V v1, V v2) {
        if (!vertices.contains(v1) || !vertices.contains(v2)) return false;
        return edges.get(v1).contains(v2);
    }

    /**
     * Checks if two vertices are connected (reachable) in the graph.
     * Uses depth-first search to explore all connected vertices.
     */
    public boolean connected(V v1, V v2) throws GraphException {
        if (!vertices.contains(v1) || !vertices.contains(v2))
            throw new GraphException("One or both vertices don't exist");
        Set<V> visited = new HashSet<>();
        return dfs(v1, v2, visited);
    }

    /**
     * Recursive DFS helper: explores from current vertex to find target.
     * Tracks visited vertices to avoid cycles and infinite recursion.
     */
    private boolean dfs(V current, V target, Set<V> visited) {
        if (current.equals(target)) return true;
        if (visited.contains(current)) return false;
        visited.add(current);
        // Recursively search through all neighbors
        for (V neighbor : edges.get(current)) {
            if (dfs(neighbor, target, visited)) return true;
        }
        return false;
    }
}
