import java.util.Scanner;
class Solution {
    public int numDecodings(String s) {
        // Time Complexity: O(N) because we loop through the string once.
        // Space Complexity: O(N) for dp array.
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            // single char
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // two char combo
            if (i > 1) {
                int number = Integer.parseInt(s.substring(i - 2, i));
                if (number >= 10 && number <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the encoded string:");
        String s = sc.nextLine();
        Solution sol = new Solution();
        System.out.println(sol.numDecodings(s));
        sc.close();
    }
}