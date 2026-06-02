package shop;

public abstract class Instrument {
    private static int counter = 0;
    private final int serial;
    public Instrument() {
        this.serial = ++counter;
    }
    public abstract int getPrice();
    public abstract String getCompany();

    public int getSerial() {
        return serial;
    }
    
    public abstract String toString();
    
}
