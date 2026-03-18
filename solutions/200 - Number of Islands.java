import java.util.*;
class Solution {
    public int numIslands(char[][] grid) {
        // Time Complexity: O(M * N) because each coordinate is potentially visited once
        //                  with DFS and checked by neighbors 4 times.
        // Space Complexity: O(M * N) for visited array.
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    flood(grid, visited, i, j);
                    total++;
                }
            }
        }
        return total;
    }

    private void flood(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length ||
            grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        flood(grid, visited, i + 1, j);
        flood(grid, visited, i - 1, j);
        flood(grid, visited, i, j + 1);
        flood(grid, visited, i, j - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter m: ");
        int m = Integer.parseInt(sc.nextLine().trim());
    
        System.out.println("Enter n: ");
        int n = Integer.parseInt(sc.nextLine().trim());
    
        char[][] grid = new char[m][n];
    
        System.out.println("Enter the grid: ");
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine().trim().replace(" ", "");
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
    
        Solution sol = new Solution();
        int result = sol.numIslands(grid);
    
        System.out.println("Number of islands: ");
        System.out.println(result);
        sc.close();
    }
}