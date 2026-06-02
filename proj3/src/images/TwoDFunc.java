package images;

/**
 * Strategy interface for a 2D function used by {@link TwoColorImage}.
 * Receives normalized coordinates (both in [0.0, 1.0]) and returns a blend factor.
 * A return value of 0 maps to the first color; 1 maps to the second. Values are clamped.
 */
public interface TwoDFunc {
    /**
     * @param x normalized x coordinate in [0.0, 1.0)
     * @param y normalized y coordinate in [0.0, 1.0)
     * @return blend factor; values outside [0, 1] are clamped
     */
    public double f(double x, double y);
}
