package images;

/**
 * Combines two images by weighted blending.
 * Where both images are defined: result = {@code alpha * base1 + (1-alpha) * base2}.
 * Where only one is defined: that image's color is used.
 * Where neither is defined: black.
 */
public class Mix extends BinaryImageDecorator {
    private final double alpha;

    public Mix(Image base1, Image base2, double alpha) {
        super(base1, base2);
        this.alpha = alpha;
    }

    @Override
    public RGB get(int x, int y) {
        boolean d1 = defined1(x, y);
        boolean d2 = defined2(x, y);
        if (d1 && d2) return RGB.mix(base1.get(x, y), base2.get(x, y), alpha);
        if (d1)       return base1.get(x, y);
        if (d2)       return base2.get(x, y);
        return RGB.BLACK;
    }
}
