import java.util.*;
class Solution {
    private int helper(int [] nums, int left, int right) {
        // Time Complexity: O(LogN) for binary search.
        // Space Complexity: O(LogN) for recursion stack. Can be optimized with iterative solution.
        if (left == right) {
            return nums[left];
        }
        int middle = left + (right - left) / 2;
        if (nums[middle] > nums[nums.length - 1]) {
            return helper(nums, middle + 1, right);
        }
        else {
            return helper(nums, left, middle);
        }
    }

    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array:");
        String[] parts = sc.nextLine().split(" ");
        int[] nums = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int result = sol.findMin(nums);
    
        System.out.println("Minimum:");
        System.out.println(result);
    
        sc.close();
    }
}