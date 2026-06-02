package bank;

public class ProAccount extends Account {
    private int[] transactions = new int[100];
    private int transactionCount = 0;

    public ProAccount(String name) {
        super(name);
    }

    @Override
    public void add(int amount) {
        super.add(amount);
        // Add transaction to history
        addTransaction();
    }

    private void addTransaction() {
        if (transactionCount < transactions.length) {
            transactions[transactionCount] = getShekels();
            transactionCount++;
        }
        else {
            System.out.println("Transaction history is full. Cannot add more transactions.");
        }
    }

    public String getHistory() {
        StringBuilder history = new StringBuilder("[");
        for (int i = 0; i < transactionCount; i++) {
            history.append(transactions[i]);
            if (i < transactionCount - 1) {
                history.append(",");
            }
        }
        history.append("]");
        return history.toString();
    }

    public String toString() {
        return getName() + " has " + getShekels() + " shekels " + getHistory();
    }

    public static void transfer(ProAccount from, ProAccount to, int amount) {
        from.add(-amount);
        to.add(amount);
    }
}
