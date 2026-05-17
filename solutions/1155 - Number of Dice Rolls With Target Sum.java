import java.util.*;
class Solution {
    private static final int MOD = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        // Time Complexity: O(N * k * target)
        // Space Complexity: O(N * target)
        // Dp state: dp[i][j] = how many ways i dice can be rolled to make j.
        // Base: dp[0][0] = 1
        // Transition: dp[i][j] = dp[i - 1][j - however many faces]
        int[][] dp = new int [n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int face = 1; face <= k; face++) {
                    if (j - face >= 0) {
                        dp[i][j] += dp[i - 1][j - face];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter n: ");
        int n = sc.nextInt();
    
        System.out.println("Enter k: ");
        int k = sc.nextInt();
    
        System.out.println("Enter target: ");
        int target = sc.nextInt();
    
        System.out.println("Number of rolls: ");
        System.out.println(new Solution().numRollsToTarget(n, k, target));
    
        sc.close();
    }
}