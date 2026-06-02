package images;

/**
 * Base class for images composed from two base images.
 * Result dimensions are the maximum width and height of the two bases.
 * Pixel (x,y) is "defined" in a base image if x &lt; width and y &lt; height of that base.
 */
public abstract class BinaryImageDecorator implements Image {
    protected final Image base1, base2;

    protected BinaryImageDecorator(Image base1, Image base2) {
        this.base1 = base1;
        this.base2 = base2;
    }

    @Override public int getWidth()  { return Math.max(base1.getWidth(),  base2.getWidth()); }
    @Override public int getHeight() { return Math.max(base1.getHeight(), base2.getHeight()); }

    protected boolean defined1(int x, int y) { return x < base1.getWidth() && y < base1.getHeight(); }
    protected boolean defined2(int x, int y) { return x < base2.getWidth() && y < base2.getHeight(); }
}
