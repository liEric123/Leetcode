import java.util.*;
class Solution {
    public int trap(int[] height) {
        // Time Complexity: O(N) for two pointers algorithm.
        //                  We keep track of boundary heights while moving the pointers in.
        // Space Complexity: O(1) for a few variables.
        int total = 0;
        int l = 0, r = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                leftMax = Math.max(leftMax, height[l]);
                total += leftMax - height[l];
                l++;
            } else {
                rightMax = Math.max(rightMax, height[r]);
                total += rightMax - height[r];
                r--;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter bar heights: ");
        String line = sc.nextLine();
        String[] parts = line.trim().split("\\s+");

        int[] height = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            height[i] = Integer.parseInt(parts[i]);
        }

        Solution sol = new Solution();
        int result = sol.trap(height);

        System.out.println("Water trapped: " + result);
        sc.close();
    }
}