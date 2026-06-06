import java.util.*;
class Solution {
    public int[] leftRightDifference(int[] nums) {
        // Time Complexity: O(N) to compute the total sum and build the answer.
        // Space Complexity: O(1) space for a few variables not counting answer array.
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int[] answer = new int[n];
        int left = 0;
        int right = sum;
        for (int i = 0; i < n; i++) {
            right -= nums[i];
            answer[i] = Math.abs(left - right);
            left += nums[i];
        }

        return answer;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] nums = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int[] result = sol.leftRightDifference(nums);
    
        System.out.println("Left right difference: ");
        System.out.println(Arrays.toString(result));
    
        sc.close();
    }
}