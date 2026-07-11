import java.util.ArrayList;
import java.util.Iterator;

public class Menu<T extends Dish> implements Iterable<T> {
    private ArrayList<T> menu = new ArrayList<T>();

    public void add(T toAdd) {
        menu.add(toAdd);
    }

    public T get(String name) {
        for (T i : menu) {
            if (i.getName().equals(name))
                return i;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        ArrayList<T> first = new ArrayList<>();
        ArrayList<T> main = new ArrayList<>();
        ArrayList<T> beverage = new ArrayList<>();
        ArrayList<T> desert = new ArrayList<>();

        for (T i : menu) {
            String category = i.getcategory();
            if ("First".equals(category))
                first.add(i);
            else if ("Main".equals(category))
                main.add(i);
            else if ("Beverage".equals(category))
                beverage.add(i);
            else if ("Desert".equals(category))
                desert.add(i);
        }

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return !first.isEmpty() || !main.isEmpty() || !beverage.isEmpty() || !desert.isEmpty();
            }

            @Override
            public T next() {
                if (!first.isEmpty())
                    return first.remove(0);
                if (!main.isEmpty())
                    return main.remove(0);
                if (!beverage.isEmpty())
                    return beverage.remove(0);
                if (!desert.isEmpty())
                    return desert.remove(0);
                throw new java.util.NoSuchElementException();
            }
        };
    }
}
