package shop;

public class Piano extends Instrument {
    private int price;
    private String company;
    private int octaves;

    public Piano(String company, int price, int octaves) {
        super();
        this.price = price;
        this.company = company;
        this.octaves = octaves;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getCompany() {
        return company;
    }

    public int getOctaves() {
        return octaves;
    }

    @Override
    public String toString() {
        return "Piano(" +
                octaves + " octaves) " +
                company + " " + getSerial() + ", " +
                "price = " + price;
    }
}
