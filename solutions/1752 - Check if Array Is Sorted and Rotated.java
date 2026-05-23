import java.util.*;
class Solution {
    public boolean check(int[] nums) {
        // Time Complexity: O(N) to loop over the array.
        // Space Complexity: O(1) for a few variables.
        int split = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                split++;
            }
        }

        if (split == 1) {
            return nums[nums.length - 1] <= nums[0];
        }

        return split == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter nums: ");
        String line = sc.nextLine();

        String[] parts = line.split(" ");
        int[] nums = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        Solution sol = new Solution();
        boolean result = sol.check(nums);

        System.out.println("Is sorted and rotated?: ");
        System.out.println(result);

        sc.close();
    }
}