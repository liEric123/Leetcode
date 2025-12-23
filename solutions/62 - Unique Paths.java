import java.util.*;
class Solution {
    public int uniquePaths(int m, int n) {
        // Time Complexity: O(M * N) because we loop over each cell to build dp array.
        // Space Complexity: O(M * N) for dp array.
        int[][] dp = new int[m][n];
        for (int[] i : dp) {
            Arrays.fill(i, 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        int m = sc.nextInt();

        System.out.println("Enter number of columns: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        System.out.println("Unique paths: " + sol.uniquePaths(m, n));

        sc.close();
    }
}