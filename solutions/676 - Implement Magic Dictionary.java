import java.util.*;
// Represents a node in a Trie. Only need to consider lower-case letters.
class TrieNode {
    TrieNode[] children;
    boolean end;

    public TrieNode() {
        children = new TrieNode[26];
        end = false;
    }
}
class MagicDictionary {
    // Space Complexity: O(N) for all the words that need to be stored in the dictionary.
    private TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        // Time Complexity: O(N) to build the Trie for all the words in the dictionary.
        for (String s : dictionary) {
            TrieNode currNode = root;
            for (char c : s.toCharArray()) {
                if (currNode.children[c - 'a'] == null) {
                    currNode.children[c - 'a'] = new TrieNode();
                }

                currNode = currNode.children[c - 'a'];
            }
            currNode.end = true;
        }
    }
    
    public boolean search(String searchWord) {
        // Time Complexity: O(N) for the length of the word to search for.
        //                  We can branch up to 26 times per node, but once there is a mismatch,
        //                  it cannot branch again. So thats why not exponential time complexity.
        return dfs(searchWord, 0, root, false);
    }

    private boolean dfs(String searchWord, int index, TrieNode root, boolean differ) {
        if (index == searchWord.length()) {
            // Need to differ in exactly one and be exactly the same length.
            return root.end && differ == true;
        }

        int currCharIdx = searchWord.charAt(index) - 'a';
        for (int i = 0; i < 26; i++) {
            if (currCharIdx == i) {
                if (root.children[i] != null && dfs(searchWord, index + 1, root.children[i], differ)) {
                    return true;
                }
            } else {
                // Prevent more than 1 differing character.
                if (differ == false) {
                    if (root.children[i] != null && dfs(searchWord, index + 1, root.children[i], true)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter dictionary words:");
        String[] dictionary = sc.nextLine().split(" ");
    
        MagicDictionary obj = new MagicDictionary();
        obj.buildDict(dictionary);
    
        System.out.println("Enter search words:");
        String[] searchWords = sc.nextLine().split(" ");
    
        System.out.println("Search results:");
        for (String word : searchWords) {
            System.out.println(word + ": " + obj.search(word));
        }
    
        sc.close();
    }
}