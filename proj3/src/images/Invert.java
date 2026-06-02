package images;

/** Inverts every pixel of the base image — each channel becomes {@code 1 - original}. */
public class Invert extends ImageDecorator {
    public Invert(Image base) {
        super(base);
    }

    @Override
    public RGB get(int x, int y) {
        return base.get(x, y).invert();
    }
}
