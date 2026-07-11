
public class POS {

    private double balance;
    private Date time;

    public POS(double balance) {
        this.balance = balance;
        time = new Date();
    }

    public synchronized void updateBalance(double payment) throws exception {
        if (balance < payment) throw new POSNegativeBalanceException();
        else {
            this.balance -= payment;
            time = new Date();
        }
    }

    public class POSNegativeBalanceException extends Exception { }
}
