import java.util.*;
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Time Complexity: O(LogM + LogN) because we use binary search to find the row of the target.
        //                  Then we use binary search again in the row to find the target.
        // Space Complexity: O(1) for some variables.
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int bottom = rows - 1;
        int targetRow = -1;
        while (top <= bottom) {
            int middle = top + (bottom - top) / 2;
            if  (matrix[middle][0] <= target && matrix[middle][cols - 1] >= target) {
                targetRow = middle;
                break;
            }
            if (matrix[middle][0] > target) {
                bottom = middle - 1;
            } else {
                top = middle + 1;
            }
        }
        if (targetRow == -1) {
            return false;
        }
        int left = 0;
        int right = cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[targetRow][mid] == target) {
                return true;
            }
            if (matrix[targetRow][mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows (m): ");
        int m = sc.nextInt();

        System.out.print("Enter number of columns (n): ");
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        System.out.println("Enter the matrix elements: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        Solution sol = new Solution();
        boolean result = sol.searchMatrix(matrix, target);

        System.out.println("Target found?: " + result);

        sc.close();
    }
}