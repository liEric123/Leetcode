import java.util.*;
class Solution {
    public int numberOfSpecialChars(String word) {
        // Time Complexity: O(N) to loop over the string once and to find matches.
        // Space Complexity: O(26) for the seen arrays.
        int count = 0;
        boolean[] seenLower = new boolean[26];
        boolean[] seenUpper = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (Character.isUpperCase(curr)) {
                seenUpper[curr - 'A'] = true;
            } else {
                seenLower[curr - 'a'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (seenLower[i] && seenUpper[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the word: ");
        String word = sc.nextLine();
    
        Solution sol = new Solution();
        int result = sol.numberOfSpecialChars(word);
    
        System.out.println("Number of special characters: ");
        System.out.println(result);
    
        sc.close();
    }
}