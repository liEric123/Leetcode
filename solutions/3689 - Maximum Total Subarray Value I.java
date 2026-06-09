import java.util.*;
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        // Time Complexity: O(N) to loop over the array finding the min and max elements.
        //                  Since we only want the max and min elements, we don't care
        //                  about subarrays as the entire array can do just as well or better
        //                  than any subarray.
        // Space Complexity: O(1) for a few variables.
        int mini = nums[0];
        int maxi = nums[0];

        for (int i : nums) {
            if (i > maxi) {
                maxi = i;
            } else if (i < mini) {
                mini = i;
            }
        }

        return (long) (maxi - mini) * k;
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

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        Solution sol = new Solution();
        long result = sol.maxTotalValue(nums, k);

        System.out.println("Maximum total value: ");
        System.out.println(result);

        sc.close();
    }
}