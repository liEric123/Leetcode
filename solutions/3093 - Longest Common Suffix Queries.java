import java.util.*;
// TrieNode structure.
// Stores up to 26 children, the smallest string length, and the min index of that prefix.
class TrieNode {
    TrieNode[] children;
    int smallestLen; // Min length for all words that have this prefix.
    int minIndex; // Min index for words of min length.

    public TrieNode() {
        children = new TrieNode[26];
        smallestLen = Integer.MAX_VALUE;
        minIndex = Integer.MAX_VALUE;
    }
}

class Solution {
    private TrieNode root;

    // Insert the word and its index into appropriate place in Trie.
    // Keep checking if we can update a node.
    private void insert(String word, int idx) {
        TrieNode curr = root;
        if (word.length() < curr.smallestLen ||
            (word.length() == curr.smallestLen && idx < curr.minIndex)) {
            curr.smallestLen = word.length();
            curr.minIndex = idx;
        }
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }

            curr = curr.children[c - 'a'];
            if (word.length() < curr.smallestLen ||
                (word.length() == curr.smallestLen && idx < curr.minIndex)) {
                curr.smallestLen = word.length();
                curr.minIndex = idx;
            }
        }
    }

    // Search the Trie with the word for best index of longest common prefix.
    private int search(String word) {
        int answer = root.minIndex;
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                break;
            }

            curr = curr.children[c - 'a'];
            answer = curr.minIndex;
        }

        return answer;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        // Time Complexity: O(N + M) to build the Trie with all words in wordsContainer.
        //                  And to query each word in wordsQuery in the Trie.
        // Space Complexity: O(N) to store all words in wordsContainer.

        root = new TrieNode();
        int[] answer = new int[wordsQuery.length];
        
        // Longest common suffix -> reverse -> longest common prefix.
        // Insert every wordsContainer string into Trie.
        for (int i = 0; i < wordsContainer.length; i++) {
            String curr = wordsContainer[i];
            StringBuilder sb = new StringBuilder(curr).reverse();
            insert(sb.toString(), i);
        }

        // Query for each wordsQuery string.
        for (int i = 0; i < wordsQuery.length; i++) {
            String curr = wordsQuery[i];
            StringBuilder sb = new StringBuilder(curr).reverse();
            answer[i] = search(sb.toString());
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter wordsContainer:");
        String containerLine = sc.nextLine();

        System.out.println("Enter wordsQuery:");
        String queryLine = sc.nextLine();

        String[] wordsContainer = containerLine.split(" ");
        String[] wordsQuery = queryLine.split(" ");

        Solution sol = new Solution();
        int[] result = sol.stringIndices(wordsContainer, wordsQuery);

        System.out.println("Result:");
        System.out.println(Arrays.toString(result));

        sc.close();
    }
}