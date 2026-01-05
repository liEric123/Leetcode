import java.util.*;
class Solution {
    public void setZeroes(int[][] matrix) {
        // Time Complexity: O(M * N) to scan through the matrix for 0s.
        // Space Complexity: O(1) for a few variables. We modify the matrix in place.
        int rows = matrix.length, cols = matrix[0].length;
        // Keeps track of whether or not we need to make row1 and col1 0s at the end.
        boolean row1 = false, col1 = false;
        // Find if col1 has a 0 in it.
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                col1 = true;
            }
        }
        // Find if row1 has a 0 in it.
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                row1 = true;
            }
        }
        // find 0s and make first col and first row 0 as a marker.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // make row 0 based on marker. We skip row 0 because that is dealt seperately.
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // make column 0 based on marker. We skip column 0 because that is dealt seperately.
        for (int j = 1; j < cols; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // Make row1 0 if indicator is true.
        if (row1) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
        // Make col1 0 if indicator is true.
        if (col1) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        Solution solution = new Solution();
        solution.setZeroes(matrix);
        System.out.println("The matrix is: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}