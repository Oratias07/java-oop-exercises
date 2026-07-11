import java.util.ArrayList;
import java.util.Iterator;

public class Basket<T extends Describable> implements Iterable {
    java.util.List<T> components;

    @Override
    public Iterator<T> iterator() {
        return components.iterator();
    }

    public Basket() {
        components = new ArrayList<>();
    }

    public void add(T item) {
        components.add(item);
    }
    
    public double getMaxPrice() {
        double maxPrice = this.components.get(0).getPrice();
        for (components i : components) {
            if (i.getPrice() > maxPrice)
                maxPrice = i.getPrice();
        }
        return maxPrice;
    }

    public double calcTotalBasket(int discountPrec) {
        double total = 0;
        for (components i : components) {
            total += i.getPrice();
        }
        return total * (100 - discountPrec)/100;
    }

    public void combineBaskets(Basket<? super T> other) {
        other.components.addAll(components);
    }
}
