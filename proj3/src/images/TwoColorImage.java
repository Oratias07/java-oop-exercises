package images;

/**
 * Generates any two-color image using the Strategy pattern.
 * A {@link TwoDFunc} receives normalized coordinates (x/width, y/height) and returns a blend factor.
 * Factor 0 → {@code zero} color; factor 1 → {@code one} color; intermediate values → weighted blend.
 * Values outside [0, 1] are clamped.
 */
public class TwoColorImage extends BaseImage {
    private final RGB zero, one;
    private final TwoDFunc func;

    public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
        super(width, height);
        this.zero = zero;
        this.one  = one;
        this.func = func;
    }

    @Override
    public RGB get(int x, int y) {
        double xn = (double) x / getWidth();
        double yn = (double) y / getHeight();
        double f  = Math.max(0, Math.min(1, func.f(xn, yn)));
        return RGB.mix(one, zero, f);
    }
}
