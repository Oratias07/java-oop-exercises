package equiv;

public class Equiv<E> {
    private java.util.Map<E, E> parent = new java.util.HashMap<>();

    public void add(E e1, E e2) {
        parent.put(find(e1), find(e2));
    }

    private E find(E e) {
        parent.putIfAbsent(e, e);
        if (!parent.get(e).equals(e)) {
            parent.put(e, find(parent.get(e)));
        }
        return parent.get(e);
    }

    public boolean are(E e1, E e2) {
        return find(e1).equals(find(e2));
    }
    
}
