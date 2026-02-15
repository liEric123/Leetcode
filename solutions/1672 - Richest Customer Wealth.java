import java.util.*;
class Solution {
    public int maximumWealth(int[][] accounts) {
        // Time Complexity: O(M * N) to loop over each bank account for each customer.
        // Space Complexity: O(1) for a few variables.
        int maxi = 0;
        for (int[] i : accounts) {
            int curr = 0;
            for (int j : i) {
                curr += j;
            }
            maxi = Math.max(maxi, curr);
        }
        return maxi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter m and n:");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] accounts = new int[m][n];
        System.out.println("Enter accounts values for each customer: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                accounts[i][j] = sc.nextInt();
            }
        }

        int ans = new Solution().maximumWealth(accounts);
        System.out.println("Maximum wealth: " + ans);

        sc.close();
    }
}