import java.util.*;
class Solution {
    int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numberOfCleanRooms(int[][] room) {
        // Time Complexity: O(N * M) to simulate robot movement.
        //                  Robot can visit each cell a constant.
        // Space Complexity: O(N * M) for visited arrays.
        int m = room.length;
        int n = room[0].length;
        boolean[][] visitedCell = new boolean[m][n];
        boolean[][][] visitedState = new boolean[m][n][4];
        int row = 0;
        int col = 0;
        int dir = 0; // 0 = right, 1 = down, 2 = left, 3 = up
        int cleaned = 0;

        while (!visitedState[row][col][dir]) {
            visitedState[row][col][dir] = true;
            if (!visitedCell[row][col]) {
                visitedCell[row][col] = true;
                cleaned++;
            }

            int potentialRow = row + moves[dir][0];
            int potentialCol = col + moves[dir][1];
            
            if (potentialRow < m && potentialRow >= 0 && potentialCol < n && potentialCol >= 0 && room[potentialRow][potentialCol] == 0) {
                row = potentialRow;
                col = potentialCol;
            } else {
                dir = (dir + 1) % 4;
            }
        }

        return cleaned;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter room rows (comma-separated): ");
        String[] rows = sc.nextLine().split(",");
    
        int[][] room = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            room[i] = Arrays.stream(rows[i].trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    
        System.out.println("Cleaned rooms: ");
        System.out.println(new Solution().numberOfCleanRooms(room));
    
        sc.close();
    }
}