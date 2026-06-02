package shop;

public class Guitar extends Instrument {
    private String company;
    private Type type;
    private int price;

    public Guitar(String company, int price, Type type) {
        super();
        this.company = company;
        this.price = price;
        this.type = type;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getCompany() {
        return company;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Guitar(" +
                type + ") " +
                company + " " + getSerial() + ", " +
                "price = " + price;
    }
}
