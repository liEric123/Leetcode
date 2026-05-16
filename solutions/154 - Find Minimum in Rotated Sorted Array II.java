import java.util.*;
class Solution {
    public int findMin(int[] nums) {
        // Time Complexity: O(LogN), but can be O(N) for all duplicates.
        // Space Complexity: O(1) for a few variables.
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[r]) {
                r = m;
            }
            else if (nums[m] > nums[r]) {
                l = m + 1;
            }
            else {
                r--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array: ");
        String[] parts = sc.nextLine().split(" ");
        int[] nums = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int result = sol.findMin(nums);
    
        System.out.println("Minimum: ");
        System.out.println(result);
    
        sc.close();
    }
}