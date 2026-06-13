import java.util.*;
class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        // Time Complexity: O(N * L) to loop through all the words.
        // Space Complexity: O(N) for a StringBuilder for the mapped chars for all words.
        StringBuilder sb = new StringBuilder();

        for (String s : words) {
            int wordWeight = 0;
            for (int i = 0; i < s.length(); i++) {
                wordWeight += weights[s.charAt(i) - 'a'];
            }
            wordWeight %= 26;
            // Reverse mapping.
            sb.append((char) (25 - wordWeight + 'a'));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter words: ");
        String[] words = sc.nextLine().trim().split("\\s+");
    
        System.out.println("Enter weights: ");
        String[] weightParts = sc.nextLine().trim().split("\\s+");
        int[] weights = new int[weightParts.length];
    
        for (int i = 0; i < weightParts.length; i++) {
            weights[i] = Integer.parseInt(weightParts[i]);
        }
    
        Solution sol = new Solution();
        String result = sol.mapWordWeights(words, weights);
    
        System.out.println("Mapped word weights: ");
        System.out.println(result);
    
        sc.close();
    }
}