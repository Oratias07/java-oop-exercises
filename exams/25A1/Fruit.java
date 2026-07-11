public class Fruit implements Describable {
    private String descString, priceString, typeString = "Fruit";
    
    public Fruit(String description, double price) throws ExpensiveFruitException {
        this.descString = description;
        setPrice(price);
    }
    @Override
    public String getDescrition() {
        return descString;
    }

    @Override
    public double getPrice() {
        return priceString;
    }

    @Override
    public String getType() {
        return typeString;
    }

    public void setPrice(double price) {
        if (price <= 100)
            this.priceString = String.valueOf(price);
        else
            throw new Fruit.ExpensiveFruitException();

    }

    public class ExpensiveFruitException extends Exception {
    }
}
