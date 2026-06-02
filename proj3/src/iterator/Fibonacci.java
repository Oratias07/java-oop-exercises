package iterator;

// MyIterator interface, MyArray and Fibonacci classes, and IteratorTester class are defined in separate files.
// The Fibonacci class implements the MyIterator interface to generate Fibonacci numbers up to a specified upper bound.
public class Fibonacci implements MyIterator {
    private int current;
    private int next;
    private int upperBound;
    private int lastResult;

    // Constructor that initializes the upper bound for the Fibonacci sequence and sets the initial values for current, next, and lastResult.
    public Fibonacci(int upperBound) {
        this.upperBound = upperBound;
        this.current = 1;
        this.next = 1;
        this.lastResult = 0;
    }

    // hasNext() method checks if the current Fibonacci number is less than the upper bound, indicating that there are more numbers to generate.
    @Override
    public boolean hasNext() {
        return current <= upperBound;
    }

    // next() method returns the current Fibonacci number and updates the current and next values to the next two Fibonacci numbers. If the upper bound is reached, it returns the last Fibonacci number generated.
    @Override
    public int next() {
        if (!hasNext()) {
            return lastResult; // Return the last Fibonacci number if the upper bound is reached.
        }
        int result = current;
        int temp = current;
        current = next;
        next = temp + next;
        lastResult = result;
        return result;
    }
}
