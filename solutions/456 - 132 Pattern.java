import java.util.*;
class Solution {
    public boolean find132pattern(int[] nums) {
        // Time Complexity: O(N) since each element is pushed and popped from stack once.
        // Space Complexity: O(N) for the stack. Worst case increasing array.
        
        int n = nums.length - 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[n]);
        int bestTwo = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < bestTwo) {
                return true;
            } else {
                // Last popped value is largest. This is because stack is decreasing.
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    bestTwo = stack.pop();
                }
                stack.push(nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter array: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] nums = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        boolean result = sol.find132pattern(nums);
    
        System.out.println("Contains 132 pattern?: ");
        System.out.println(result);
    
        sc.close();
    }
}