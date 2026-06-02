package images;

/**
 * Decorator base class for images derived from a single base image with the same dimensions.
 * Subclasses override {@code get} to transform each pixel.
 */
public abstract class ImageDecorator implements Image {
    protected final Image base;

    protected ImageDecorator(Image base) {
        this.base = base;
    }

    @Override public int getWidth()  { return base.getWidth(); }
    @Override public int getHeight() { return base.getHeight(); }
}
