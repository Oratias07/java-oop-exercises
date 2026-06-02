package images;

/**
 * Represents a color in RGB color space.
 * Each channel (red, green, blue) holds a value in [0.0, 1.0].
 * Immutable — all operations return new RGB instances.
 */
public class RGB {
    public static final RGB BLACK = new RGB(0);
    public static final RGB WHITE = new RGB(1);
    public static final RGB RED   = new RGB(1, 0, 0);
    public static final RGB GREEN = new RGB(0, 1, 0);
    public static final RGB BLUE  = new RGB(0, 0, 1);

    private final double red, green, blue;

    /** Creates an RGB color from three channel values, each in [0.0, 1.0]. */
    public RGB(double red, double green, double blue) {
        this.red   = red;
        this.green = green;
        this.blue  = blue;
    }

    /** Creates a grey color — all three channels set to {@code grey}. */
    public RGB(double grey) {
        this(grey, grey, grey);
    }

    /** @return red channel value in [0.0, 1.0]. */
    public double getRed()   { return red; }
    /** @return green channel value in [0.0, 1.0]. */
    public double getGreen() { return green; }
    /** @return blue channel value in [0.0, 1.0]. */
    public double getBlue()  { return blue; }

    /**
     * Returns a new color with each channel inverted: {@code 1 - channel}.
     * Does not modify this instance.
     */
    public RGB invert() {
        return new RGB(1 - red, 1 - green, 1 - blue);
    }

    /**
     * Returns a new color where each channel is multiplied by the corresponding channel of {@code filter}.
     * White filter leaves the color unchanged; other filters reduce brightness proportionally.
     */
    public RGB filter(RGB f) {
        return new RGB(red * f.red, green * f.green, blue * f.blue);
    }

    /**
     * Simulates projecting two colored lights together.
     * Each channel is the sum of the two channels, capped at 1.0.
     */
    public static RGB superpose(RGB a, RGB b) {
        return new RGB(Math.min(a.red + b.red, 1),
                       Math.min(a.green + b.green, 1),
                       Math.min(a.blue + b.blue, 1));
    }

    /**
     * Returns a weighted blend: {@code alpha * rgb1 + (1 - alpha) * rgb2}.
     * alpha=1 gives rgb1; alpha=0 gives rgb2.
     */
    public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
        return new RGB(alpha * rgb1.red   + (1 - alpha) * rgb2.red,
                       alpha * rgb1.green + (1 - alpha) * rgb2.green,
                       alpha * rgb1.blue  + (1 - alpha) * rgb2.blue);
    }

    /** Returns the color as {@code <r, g, b>} with four decimal places, e.g. {@code <0.2000, 0.7000, 0.1110>}. */
    @Override
    public String toString() {
        return String.format("<%.4f, %.4f, %.4f>", red, green, blue);
    }
}
