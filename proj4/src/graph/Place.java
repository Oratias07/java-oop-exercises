package graph;

/**
 * Represents a 2D coordinate (x, y) within a bounded grid.
 * Enforces boundary constraints via constructor validation.
 */
public class Place {
    private int x, y;
    /**
     * Creates a Place with boundary validation.
     * Coordinates must be within [0, bound).
     */
    public Place(int x, int y, int bound) {
        // Validate coordinates are within valid range [0, bound-1]
        if (x < 0 || x > bound -1 ||
            y < 0 || y > bound -1) {
                throw new IllegalArgumentException("Argument values outside allowed boundaries");
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Two Places are equal if they have the same x and y coordinates.
     * Type-checks object before casting to avoid ClassCastException.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Place)) return false;
        Place other = (Place) obj;
        return this.x == other.x && this.y == other.y;
    }

    /**
     * Hash code combines x and y for use in hash-based collections.
     * Formula: 31*x + y provides good distribution for small grid coordinates.
     */
    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
