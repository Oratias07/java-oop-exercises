package graph;

/**
 * Exception thrown when an invalid graph operation is attempted
 * (e.g., adding duplicate vertex, invalid edges).
 */
@SuppressWarnings("serial")
public class GraphException extends Exception {
    public GraphException(String str) {
        super(str);
    }
}
