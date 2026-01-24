import java.util.*;
class Solution {
    public int scoreOfString(String s) {
        // Time Complexity: O(N) to loop over the string.
        // Space Complexity: O(1) for a few variables.
        int score = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String input = sc.nextLine();

        Solution solution = new Solution();
        int result = solution.scoreOfString(input);

        System.out.println("Score of the string: ");
        System.out.println(result);

        sc.close();
    }
}