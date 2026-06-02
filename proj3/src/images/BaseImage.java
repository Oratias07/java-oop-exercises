package images;

/**
 * Base class for images that stand alone (not derived from other images).
 * Stores fixed width and height; subclasses implement the color computation.
 */
public abstract class BaseImage implements Image {
    private final int width, height;

    protected BaseImage(int width, int height) {
        this.width  = width;
        this.height = height;
    }

    @Override public int getWidth()  { return width; }
    @Override public int getHeight() { return height; }
}
