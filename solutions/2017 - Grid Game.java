import java.util.*;
class Solution {
    public long gridGame(int[][] grid) {
        // Time Complexity: O(N) to first loop over the top row sum and then
        //                  to check each column for best turning point for the first robot.
        // Space Complexity: O(1) for a few variables.
        int n = grid[0].length;
        // Use long since the sum can scale past int limits.
        long topRowSum = 0;
        long bottomRowSum = 0;
        for (int j = 0; j < n; j++) {
            topRowSum += grid[0][j];
        }
        
        // The second robot plays optimally, selecting between taking top or bottom rows.
        // The first robot wants to minimize the second robot's optimal points.
        long secondRobotMin = Long.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            // What if we go down here?
            topRowSum -= grid[0][j];
            secondRobotMin = Math.min(secondRobotMin, Math.max(topRowSum, bottomRowSum));
            bottomRowSum += grid[1][j];
        }

        return secondRobotMin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter top row: ");
        String topLine = sc.nextLine();
    
        System.out.println("Enter bottom row: ");
        String bottomLine = sc.nextLine();
    
        String[] topParts = topLine.split(" ");
        String[] bottomParts = bottomLine.split(" ");
    
        int[][] grid = new int[2][topParts.length];
    
        for (int i = 0; i < topParts.length; i++) {
            grid[0][i] = Integer.parseInt(topParts[i]);
            grid[1][i] = Integer.parseInt(bottomParts[i]);
        }
    
        Solution sol = new Solution();
        long result = sol.gridGame(grid);
    
        System.out.println("Minimum points for second robot: ");
        System.out.println(result);
    
        sc.close();
    }
}