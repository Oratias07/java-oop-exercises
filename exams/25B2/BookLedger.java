import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;

public class BookLedger<T extends Payable> {
    HashMap<String, T> bl = new HashMap<>();

    public T getPayable(String details) {
        return book.get(details);
    }

    @Override
    public void addPayable(T item) {
        bl.put(item.getPayeeDetails(), item);
    }

    public double getTotalFiscal() {
        double total = 0;
        for (T item : bl.values())
            total += item.getPayment();
        return total;
    }

    public double getTotalCommission() {
        double total = 0;
        for (T item : bl.values())
            total += item.getCommission();
        return total;
    }
}