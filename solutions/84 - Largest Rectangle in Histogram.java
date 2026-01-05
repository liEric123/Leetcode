import java.util.*;
class Solution {
    public int largestRectangleArea(int[] heights) {
        // Time Complexity: O(N) because each height is pushed and popped only once.
        // Space Complexity: O(N) for the stack.
        int maxi = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek()] > heights[i])) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxi = Math.max(maxi, height * width);
            }
            stack.push(i);
        }
        return maxi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the heights: ");
        String line = sc.nextLine();
        String[] parts = line.trim().split("\\s+");
        int[] heights = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            heights[i] = Integer.parseInt(parts[i]);
        }
        Solution sol = new Solution();
        System.out.println("Largest rectangle area: " + sol.largestRectangleArea(heights));
        sc.close();
    }
}