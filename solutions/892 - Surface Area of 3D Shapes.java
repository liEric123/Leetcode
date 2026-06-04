import java.util.*;
class Solution {
    public int surfaceArea(int[][] grid) {
        // Time Complexity: O(N^2) to loop over each block grid.
        // Space Complexity: O(1) for a few variables.

        // For each cube, compute its surface area. Need to avoid double counting or undercounting.
        // Look at its neighbors to the right and bottom. This is because we loop right and down.
        // If there is overlap, we remove it both for the cell and its neighbor.
        // Add current surface area to the total.

        int n = grid.length;
        int totSA = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int currSA = 4 * grid[i][j] + 2;
                if (j + 1 < n) {
                    int rightOverlap = Math.min(grid[i][j], grid[i][j + 1]);
                    currSA -= 2 * rightOverlap;
                }

                if (i + 1 < n) {
                    int bottomOverlap = Math.min(grid[i][j], grid[i + 1][j]);
                    currSA -= 2 * bottomOverlap;
                }

                totSA += currSA;
            }
        }

        return totSA;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter n: ");
        int n = Integer.parseInt(sc.nextLine());
    
        int[][] grid = new int[n][n];
    
        System.out.println("Enter the grid: ");
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(parts[j]);
            }
        }
    
        Solution sol = new Solution();
        int result = sol.surfaceArea(grid);
    
        System.out.println("Surface area: ");
        System.out.println(result);
    
        sc.close();
    }
}