package images;

/**
 * Applies a color filter to every pixel of the base image.
 * Each channel of the result equals the base channel multiplied by the filter channel.
 */
public class Filter extends ImageDecorator {
    private final RGB filter;

    public Filter(Image base, RGB filter) {
        super(base);
        this.filter = filter;
    }

    @Override
    public RGB get(int x, int y) {
        return base.get(x, y).filter(filter);
    }
}
