import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Time Complexity: O(N^2) for two loops for search every possible split
        //                         for each substring.
        // Space Complexity: O(N + M) for dp array and HashSet. 
        Set<String> hashWords = new HashSet<>();
        for (String str : wordDict) {
            hashWords.add(str);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && hashWords.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.println("Enter the string:");
        String s = sc.nextLine();

        System.out.println("Enter dictionary words separated by spaces:");
        String[] words = sc.nextLine().split("\\s+");

        List<String> wordDict = Arrays.asList(words);

        boolean result = sol.wordBreak(s, wordDict);
        System.out.println(result);
        sc.close();
    }
}