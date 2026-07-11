import java.util.ArrayList;

public class Util {
    public static <E extends Dish> Menu<Cake> getCakes(Menu<E> m) {
        Menu<Cake> cakes = new Menu<Cake>(); 
        Iterator<E> it = m.iterator(); 
        while(it.hasNext()) {
            E next = it.next(); 
            if (next instanceof Cake) 
                cakes.add((Cake)next); 
        } 
        return cakes; 
    }
}
