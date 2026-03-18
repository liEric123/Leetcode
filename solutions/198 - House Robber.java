import java.util.*;
class Solution {
    public int rob(int[] nums) {
        // Time Complexity: O(N) to loop through each house.
        // Space Complexity: O(1) for a few variables.
        int dp2 = 0;
        int dp1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = Math.max(dp2 + nums[i], dp1);
            dp2 = dp1;
            dp1 = curr;
        }
        return dp1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array: ");
        String line = sc.nextLine().trim();
    
        int[] nums;
        if (line.isEmpty()) {
            nums = new int[0];
        } else {
            String[] parts = line.split(" ");
            nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
        }
    
        Solution sol = new Solution();
        int result = sol.rob(nums);
    
        System.out.println("Maximum amount: ");
        System.out.println(result);
    
        sc.close();
    }
}