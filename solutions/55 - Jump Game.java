import java.util.Scanner;
class Solution {
    public boolean canJump(int[] nums) {
        // Time Complexity: O(N) to loop through each index.
        // Space Complexity: O(1) for some variables.
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (farthest < i) {
                return false;
            }
            farthest = Math.max(i + nums[i], farthest);
        }
        if (farthest >= nums.length - 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the array elements: ");
        String line = sc.nextLine();

        String[] parts = line.trim().split("\\s+");
        int[] nums = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        Solution sol = new Solution();
        boolean result = sol.canJump(nums);

        System.out.println("Can reach the last index: " + result);
        sc.close();
    }
}