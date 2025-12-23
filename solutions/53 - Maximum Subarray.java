import java.util.Scanner;
class Solution {
    public int maxSubArray(int[] nums) {
        // Time Complexity: O(N) because we calculate the maximum sum ending at i.
        // Space Complexity: O(1) for a few variables.
        int maxi = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(curr + nums[i], nums[i]);
            maxi = Math.max(curr, maxi);
        }
        return maxi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the array: ");
        String line = sc.nextLine();

        String[] parts = line.split(" ");
        int[] nums = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        Solution sol = new Solution();
        int result = sol.maxSubArray(nums);

        System.out.println("Maximum subarray sum:");
        System.out.println(result);
        sc.close();
    }
}