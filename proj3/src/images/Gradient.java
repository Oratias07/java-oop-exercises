package images;

/**
 * A horizontal color gradient image.
 * The leftmost column has the start color; color blends linearly toward the end color moving right.
 * The blend uses {@code alpha = 1 - x/width}, so the rightmost column is nearly (but not exactly) the end color.
 */
public class Gradient extends BaseImage {
    private final RGB start, end;

    public Gradient(int width, int height, RGB start, RGB end) {
        super(width, height);
        this.start = start;
        this.end   = end;
    }

    @Override
    public RGB get(int x, int y) {
        double alpha = 1.0 - (double) x / getWidth();
        return RGB.mix(start, end, alpha);
    }
}
