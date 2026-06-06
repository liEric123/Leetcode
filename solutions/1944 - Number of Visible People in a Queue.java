import java.util.*;
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        // Time Complexity: O(N) to loop through each minion, starting from the right.
        //                  Each height is pushed onto the stack once, and popped once.
        // Space Complexity: O(N) for a monotonically decreasing stack and answer array.
        int n = heights.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            // Count minions we can see (taller than).
            // We pop from stack because they can never help future answers again.
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                answer[i]++;
            }
            // If not empty, then this minion blocks us, but we can see it still.
            if (!stack.isEmpty()) {
                answer[i]++;
            }
            // Push current element onto the stack as it satisfies the monotonic property now.
            stack.push(heights[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter heights: ");
        String line = sc.nextLine();
    
        String[] parts = line.split(" ");
        int[] heights = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            heights[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int[] result = sol.canSeePersonsCount(heights);
    
        System.out.println("Visible persons count: ");
        System.out.println(Arrays.toString(result));
    
        sc.close();
    }
}