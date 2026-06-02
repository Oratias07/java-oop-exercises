package tree;

public class Node {
    private int count;
    private Node[] children = new Node['z' - 'a' + 1];

    // returns the number of strrings s that have been added to the trie and have s as a prefix, when the trie is represented by the current node
    public int num(String s) {
        if (s.length() == 0) {
            return count;
        }
        char c = s.charAt(0);
        int index = c - 'a';
        if (children[index] == null) {
            return 0;
        }
        return children[index].num(s.substring(1));
    }

    // adds the string s to the trie, when the current node is considered the root of the trie.
    public void add(String s) {
        if (s.length() == 0) {
            count++;
            return;
        }
        char c = s.charAt(0);
        int index = c - 'a';
        if (children[index] == null) {
            children[index] = new Node();
        }
        children[index].add(s.substring(1));
    }
}
