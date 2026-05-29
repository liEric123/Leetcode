import java.util.*;
// Represents a node in a Trie (prefix tree).
// Has an indicator of whether a string is terminated or not.
class TrieNode {
    Map<Character, TrieNode> children; // Not needed if constraints are only lowercase.
    boolean stringEnd;

    public TrieNode() {
        children = new HashMap<>();
        stringEnd = false;
    }
}

class Trie {
    // Space Complexity: O(Total characters stored)
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        // Time Complexity: O(N) to traverse the Trie and each char of the word.
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (curr.children.get(currChar) == null) {
                curr.children.put(currChar, new TrieNode());
            }

            curr = curr.children.get(currChar);
        }

        curr.stringEnd = true;
    }
    
    public boolean search(String word) {
        // Time Complexity: O(N) to search the trie and each char of the word.
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (curr.children.get(currChar) == null) {
                return false;
            }

            curr = curr.children.get(currChar);
        }
        
        return curr.stringEnd;
    }
    
    public boolean startsWith(String prefix) {
        // O(N) to search the trie and each char of the prefix.
        TrieNode curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if (curr.children.get(currChar) == null) {
                return false;
            }

            curr = curr.children.get(currChar);
        }
        
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter operations: ");
        String[] operations = sc.nextLine().split(" ");

        System.out.println("Enter values: ");
        String[] values = sc.nextLine().split(" ");

        Trie trie = null;
        ArrayList<String> output = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];

            if (op.equals("Trie")) {
                trie = new Trie();
                output.add("null");
            } else if (op.equals("insert")) {
                trie.insert(values[i]);
                output.add("null");
            } else if (op.equals("search")) {
                output.add(String.valueOf(trie.search(values[i])));
            } else if (op.equals("startsWith")) {
                output.add(String.valueOf(trie.startsWith(values[i])));
            }
        }

        System.out.println("Output: ");
        System.out.println(output);

        sc.close();
    }
}