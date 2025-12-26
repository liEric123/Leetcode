import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Time Complexity: O(M * N) because we loop over all elements in a spiral order.
        // Space Complexity: O(N * M) for the answer list.
        int mode = 1; // 1, going right; 2, going down; 3, going left; 4, going up
        List<Integer> answer = new ArrayList<>();
        int r = 0, c = 0, layer = 0;
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows * cols; i++) {
            answer.add(matrix[r][c]);
            if (mode == 1) {
                if (c < cols - layer - 1) {
                    c++;
                } else {
                    mode = 2;
                    if (r < rows - layer - 1) {
                        r++;
                    }
                }
            } else if (mode == 2) {
                if (r < rows - layer - 1) {
                    r++;
                } else {
                    mode = 3;
                    if (c > layer) {
                        c--;
                    }
                }
            } else if (mode == 3) {
                if (c > layer) {
                    c--;
                } else {
                    mode = 4;
                    if (r > layer) {
                        r--;
                    }
                }
            } else if (mode == 4) {
                if (r > layer + 1) {
                    r--;
                } else {
                    mode = 1;
                    layer++;
                    if (c < cols - layer - 1) {
                        c++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        System.out.println("Enter the number of rows and columns: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        List<Integer> result = sol.spiralOrder(matrix);
        System.out.println("Spiral order: " + result);
        sc.close();
    }
}