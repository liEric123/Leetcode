import java.util.*;
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        // Time Complexity: O(N^2) because we process each element once.
        // Space Complexity: O(1) for a few variables.
        int n = image[0].length;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][n - j - 1] ^ 1;
                image[i][n - j - 1] = temp ^ 1;
            }
            if (n % 2 == 1) {
                image[i][n / 2] ^= 1;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] image = new int[rows][cols];

        System.out.println("Enter the matrix elements: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = sc.nextInt();
            }
        }

        Solution sol = new Solution();
        int[][] result = sol.flipAndInvertImage(image);

        System.out.println("Flipped and inverted image: ");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}