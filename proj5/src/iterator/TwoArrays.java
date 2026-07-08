package iterator;
import java.util.NoSuchElementException;

public class TwoArrays implements Iterable<Integer> {
    private int[] a1;
    private int[] a2;

    public TwoArrays (int[] a1, int[] a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    @Override
    public java.util.Iterator<Integer> iterator() {
        return new java.util.Iterator<Integer>() {
            private int index1 = 0;
            private int index2 = 0;
            private boolean isFirstArray = true;

            @Override
            public boolean hasNext() {
                return index1 < a1.length || index2 < a2.length;
            }

            @Override
            public Integer next() {
                if (index1 < a1.length && (isFirstArray || index2 >= a2.length)) {
                    isFirstArray = false;
                    return a1[index1++];
                } else if (index2 < a2.length && (!isFirstArray || index1 >= a1.length)) {
                    isFirstArray = true;
                    return a2[index2++];
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}