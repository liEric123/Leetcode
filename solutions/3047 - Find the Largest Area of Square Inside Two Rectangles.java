import java.util.*;
class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        // Time Complexity: O(N^2) because we need to check each pair of rectangles.
        // Space Complexity: O(1) for a few variables.
        long maxi = 0;
        int n = bottomLeft.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xLeftBound = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int xRightBound = Math.min(topRight[i][0], topRight[j][0]);
                int yLowerBound = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int yHigherBound = Math.min(topRight[i][1], topRight[j][1]);
                if (xRightBound <= xLeftBound || yLowerBound >= yHigherBound) {
                    continue;
                }
                int side = Math.min(xRightBound - xLeftBound, yHigherBound - yLowerBound);
                maxi = Math.max(maxi, side);
            }
        }
        return maxi * maxi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rectangles: ");
        int n = sc.nextInt();

        int[][] bottomLeft = new int[n][2];
        int[][] topRight = new int[n][2];

        System.out.println("Enter bottomLeft coordinates (x y) for each rectangle: ");
        for (int i = 0; i < n; i++) {
            bottomLeft[i][0] = sc.nextInt();
            bottomLeft[i][1] = sc.nextInt();
        }

        System.out.println("Enter topRight coordinates (x y) for each rectangle: ");
        for (int i = 0; i < n; i++) {
            topRight[i][0] = sc.nextInt();
            topRight[i][1] = sc.nextInt();
        }

        Solution sol = new Solution();
        long result = sol.largestSquareArea(bottomLeft, topRight);

        System.out.println("Largest square area: " + result);
        sc.close();
    }
}