import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        // Time Complexity: O(M * N) to loop over all cells during BFS.
        // Space Complexity: O(M * N) for queue use during BFS. Worst case all rotten.
        Queue<int[]> queue = new ArrayDeque<>();
        int r = grid.length;
        int c = grid[0].length;
        int totFresh = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    totFresh++;
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty() && totFresh > 0) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] curr = queue.poll();
                if (curr[0] > 0 && grid[curr[0] - 1][curr[1]] == 1) {
                    grid[curr[0] - 1][curr[1]] = 2;
                    queue.add(new int[]{curr[0] - 1, curr[1]});
                    totFresh--;
                }
                if (curr[0] < r - 1 && grid[curr[0] + 1][curr[1]] == 1) {
                    grid[curr[0] + 1][curr[1]] = 2;
                    queue.add(new int[]{curr[0] + 1, curr[1]});
                    totFresh--;
                }
                if (curr[1] > 0 && grid[curr[0]][curr[1] - 1] == 1) {
                    grid[curr[0]][curr[1] - 1] = 2;
                    queue.add(new int[]{curr[0], curr[1] - 1});
                    totFresh--;
                }
                if (curr[1] < c - 1 && grid[curr[0]][curr[1] + 1] == 1) {
                    grid[curr[0]][curr[1] + 1] = 2;
                    queue.add(new int[]{curr[0], curr[1] + 1});
                    totFresh--;
                }
            }
            time++;
        }

        if (totFresh > 0) {
            return -1;
        }
        return time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter m: ");
        int m = sc.nextInt();
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        System.out.println("Enter the grid: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution sol = new Solution();
        int result = sol.orangesRotting(grid);

        System.out.println("Minutes: ");
        System.out.println(result);
        sc.close();
    }
}