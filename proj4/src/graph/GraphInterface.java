package graph;

import java.util.Collection;

/**
 * Interface for any graph structure that supports neighbor queries.
 */
public interface GraphInterface<V> {
    /**
     * Returns all neighbors of the given vertex.
     */
    Collection<V> neighbours(V v);
}
