import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Time Complexity: O(1) because sudoku has 9x9 board so operations are at a constant 81.
        // Space Complexity: O(1) for same reason.
        // Technically, O(N^2) for Time and Space if we generalize the board to NxN.
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> boxes = new HashMap<>();
        
        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            boxes.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if (curr == '.') {
                    continue;
                }
                int boxIdx = (i / 3) * 3 + (j / 3);
                if (rows.get(i).contains(curr) || cols.get(j).contains(curr) || boxes.get(boxIdx).contains(curr)) {
                    return false;
                }
                rows.get(i).add(curr);
                cols.get(j).add(curr);
                boxes.get(boxIdx).add(curr);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        System.out.println("Enter the board: ");
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            String[] row = sc.nextLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = row[j].charAt(0);
            }
        }
        System.out.println("The board is valid: " + solution.isValidSudoku(board));
        sc.close();
    }
}