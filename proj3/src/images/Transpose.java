package images;

/**
 * Transposes an image along the main diagonal — x and y are swapped.
 * Width and height are exchanged: a 200×100 image becomes 100×200.
 */
public class Transpose implements Image {
    private final Image base;

    public Transpose(Image base) {
        this.base = base;
    }

    @Override public int getWidth()  { return base.getHeight(); }
    @Override public int getHeight() { return base.getWidth(); }

    @Override
    public RGB get(int x, int y) {
        return base.get(y, x);
    }
}
