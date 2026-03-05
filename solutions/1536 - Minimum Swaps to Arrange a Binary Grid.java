import java.util.*;
class Solution {
    public int minSwaps(int[][] grid) {
        // Time Complexity: O(N^2) to loop over the grid looking for the rightmost 1.
        // Space Complexity: O(N) to store the rightmost 1s for each row.
        int n = grid.length;
        int[] lastOne = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    lastOne[i] = j;
                    break;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && lastOne[j] > i) {
                j++;
            }
            if (j == n) {
                return -1;
            }
            // Simulate swapping row j with row i.
            // We don't need to actually swap the grid row.
            while (j > i) {
                int temp = lastOne[j];
                lastOne[j] = lastOne[j - 1];
                lastOne[j - 1] = temp;
                j--;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        int[][] grid = new int[n][n];
        System.out.println("Enter the grid: ");
        int count = 0;
        while (count < n * n && sc.hasNext()) {
            String tok = sc.next();
            if (tok.isEmpty()) continue;
            int val = Integer.parseInt(tok);
            grid[count / n][count % n] = val;
            count++;
        }

        Solution sol = new Solution();
        int result = sol.minSwaps(grid);

        System.out.println("Minimum swaps: ");
        System.out.println(result);

        sc.close();
    }
}