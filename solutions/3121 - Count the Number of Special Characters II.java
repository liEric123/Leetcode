import java.util.*;
class Solution {
    public int numberOfSpecialChars(String word) {
        // Time Complexity: O(N) to loop over the word checking each char.
        //                  Then, O(N) again for building the answer.
        // Space Complexity: O(26) for the states array.
        

        // 4 states. not seen lowercase yet, seen lowercase, seen uppercase valid, and invalid.
        int[] states = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (Character.isLowerCase(curr)) {
                if (states[curr - 'a'] == 2) {
                    states[curr - 'a'] = 3;
                } else if (states[curr - 'a'] == 0) {
                    states[curr - 'a'] = 1;
                } 
            } else {
                if (states[curr - 'A'] == 0) {
                    states[curr - 'A'] = 3;
                } else if (states[curr - 'A'] == 1) {
                    states[curr - 'A'] = 2;
                }
            }
        }

        int count = 0;
        for (int i : states) {
            if (i == 2) {
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
    
        System.out.println("Number of special chars: ");
        System.out.println(result);
    
        sc.close();
    }
}