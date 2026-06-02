package tree;

import java.util.Scanner;

public class ReversedWords {
    // Reads from the user (meaning System.in) string by string using a Scanner, and stops when it reads the string "X". It returns the number of strings that appeared previously in the input in reverse order (exact reversal, not just a shuffle). Uses the Node class to store the strings that have already been seen.
    public static int checkReversed() {
        Node Node = new Node();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            String s = scanner.next();
            if (s.equals("X")) {
                break;
            }
            String reversed = new StringBuilder(s).reverse().toString();
            count += Node.num(reversed) > 0 ? 1 : 0;
            Node.add(s);
        }
        scanner.close();
        return count;
    }
}
