package iterator;

public class Combined<E> implements Iterable<E> {
    private Iterable<E> first;
    private Iterable<E> second;

    public Combined(Iterable<E> first, Iterable<E> second) {
        // Implementation of the constructor to combine two iterables
        this.first = first;
        this.second = second;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
                    private java.util.Iterator<E> it1 = first.iterator();
                    private java.util.Iterator<E> it2 = second.iterator();
                    private boolean isFirst = true;

                    @Override
                    public boolean hasNext() {
                        return it1.hasNext() || it2.hasNext();
                    }

                    @Override
                    public E next() {
                        if (it1.hasNext() && (isFirst || !it2.hasNext())) {
                            isFirst = false;
                            return it1.next();
                        } else if (it2.hasNext() && (!isFirst || !it1.hasNext())) {
                            isFirst = true;
                            return it2.next();
                        } else {
                            throw new java.util.NoSuchElementException();
                        }
                    }
        };
    }
}
