import java.util.*;
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // Time Complexity: O(M * N) to compare all text1 chars with text2.
        // Space Complexity: O(M  * N) for dp array.
        // dp[i][j] represents the LCS between the first i characters of text1 and
        // first j characters of text2.
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.print("Enter first string: ");
        String text1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String text2 = sc.nextLine();

        int result = solution.longestCommonSubsequence(text1, text2);
        System.out.println("LCS length: " + result);

        sc.close();
    }
}