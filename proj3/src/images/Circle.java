package images;

/**
 * An image containing a soft-edged circle on a solid background.
 * Inside the circle, color blends from {@code center} (at the exact center) to {@code outside} (at the radius).
 * Pixels outside the radius are solid {@code outside} color.
 */
public class Circle extends BaseImage {
    private final int centerX, centerY, radius;
    private final RGB center, outside;

    /** @param centerX x coordinate of circle center; @param centerY y coordinate; @param radius circle radius in pixels. */
    public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
        super(width, height);
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius  = radius;
        this.center  = center;
        this.outside = outside;
    }

    /** Convenience constructor: square image of side {@code size}, circle centered in the image. */
    public Circle(int size, int radius, RGB center, RGB outside) {
        this(size, size, size / 2, size / 2, radius, center, outside);
    }

    @Override
    public RGB get(int x, int y) {
        double dx   = x - centerX;
        double dy   = y - centerY;
        double dist = Math.sqrt(dx * dx + dy * dy);
        if (dist >= radius)
            return outside;
        double alpha = 1.0 - dist / radius;
        return RGB.mix(center, outside, alpha);
    }
}
