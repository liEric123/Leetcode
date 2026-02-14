import java.util.*;
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        // Time Complexity: O(M * N) since we loop through the entire tower.
        // Space Complexity: O(M * N) since we store the entire tower.
        /*
        The tower looks like:
        []
        [][][]
        [][][][]
        [][][][][]
        */
        double dp[][] = new double[query_row + 2][query_glass + 2];
        dp[0][0] = poured;
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= query_glass; j++) {
                if (dp[i][j] > 1) {
                    double excess = (dp[i][j] - 1) / 2;
                    dp[i + 1][j] += excess;
                    dp[i + 1][j + 1] += excess;
                }
            }
        }
        return Math.min(1, dp[query_row][query_glass]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter poured amount: ");
        int poured = sc.nextInt();

        System.out.print("Enter query row: ");
        int query_row = sc.nextInt();

        System.out.print("Enter query glass: ");
        int query_glass = sc.nextInt();

        double result = sol.champagneTower(poured, query_row, query_glass);

        System.out.println("Amount of champagne in glass: " + result);

        sc.close();
    }
}