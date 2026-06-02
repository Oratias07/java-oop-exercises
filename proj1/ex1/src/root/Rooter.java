package root;

public class Rooter {
    private double precision;

    public Rooter(double precision) {
        this.precision = precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public double sqrt(double x) {
        double guess = x / 2;
        while (Math.abs(guess * guess - x) > precision)
            guess = (guess + x / guess) / 2;
        return guess;
    }
    
}
