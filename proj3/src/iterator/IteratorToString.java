package iterator;

// MyIterator interface, MyArray and Fibonacci classes, and IteratorTester class are defined in separate files.
// The IteratorToString class contains a static method toString that takes a MyIterator object as an argument and returns a string representation of the elements in the iterator.
// The method uses a StringBuilder to construct the string, 
// iterating through the elements of the MyIterator and appending them to the StringBuilder, 
// separated by spaces, and enclosed in square brackets.
public class IteratorToString {
    public static String toString(MyIterator it) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(" ");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 1, sb.length()); // Remove the trailing space
        }
        sb.append("]");
        return sb.toString();
    }
}
