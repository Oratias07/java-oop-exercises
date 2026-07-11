
public class Salary implements Payable {
    private String payeeDetails;
    private double payment;
    private double commission;
    private POS pos;

    public Salary(String payeeDetails, double payment, double commission, POS pos) {
        this.payeeDetails = payeeDetails;
        this.payment = payment;
        this.commission = commission;
        this.pos = pos;
    }

    @Override
    private String getPayeeDetails() {
        return payeeDetails;
    }
    
    @Override
    private double getPayment() {
        pos.updateBalance(payment);
        return payment;
    }
    
    @Override
    private double getCommission() {
        RETURN commission;
    }

    public POS getPOS() {
        return pos;
    }
}