package iterator;
import java.util.NoSuchElementException;

// MyIterator interface, MyArray and Fibonacci classes, and IteratorTester class are defined in separate files.
public class MyArray implements MyIterator {
    private int[] arr;
    private int index;

    // Constructor that takes an array of integers and initializes the index to 0.
    // This constructor will be used to create an instance of MyArray with the given array.
    public MyArray(int[] arr) {
        this.arr = arr;
        this.index = 0;
    }

    // hasNext() method checks if there are more elements to iterate over by comparing the current index with the length of the array.
    @Override
    public boolean hasNext() {
        return index < arr.length;
    }

    // next() method returns the next element in the array and increments the index. If there are no more elements, it throws a NoSuchElementException.
    @Override
    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return arr[index++];
    }
    
}
