package images;

/**
 * Combines two images by simulating overlapping light projections.
 * Where both images are defined: channels are summed and capped at 1 (additive blend).
 * Where only one is defined: that image's color is used.
 * Where neither is defined: black.
 */
public class Superpose extends BinaryImageDecorator {
    public Superpose(Image base1, Image base2) {
        super(base1, base2);
    }

    @Override
    public RGB get(int x, int y) {
        boolean d1 = defined1(x, y);
        boolean d2 = defined2(x, y);
        if (d1 && d2) return RGB.superpose(base1.get(x, y), base2.get(x, y));
        if (d1)       return base1.get(x, y);
        if (d2)       return base2.get(x, y);
        return RGB.BLACK;
    }
}
