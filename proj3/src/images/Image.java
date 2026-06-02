package images;

/**
 * Represents a rectangular image.
 * Pixels are indexed from (0,0) at the top-left to (width-1, height-1) at the bottom-right.
 * Implementations compute pixel colors on-demand — no color matrix is stored.
 */
public interface Image {
    /** @return width of the image in pixels. */
    public int getWidth();
    /** @return height of the image in pixels. */
    public int getHeight();
    /**
     * Returns the color at pixel (x, y).
     * Behavior is defined for 0 &le; x &lt; getWidth() and 0 &le; y &lt; getHeight().
     */
    public RGB get(int x, int y);
}
