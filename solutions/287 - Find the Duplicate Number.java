import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        // Time Complexity: O(N) because for each number, we set its index value to be negative.
        //                  That acts like a indicator of a visited number.
        // Space Complexity: O(1) for a few variables, but we modify input array.
        for (int i : nums) {
            int idx = Math.abs(i) - 1;
            if (nums[idx] < 0) {
                return Math.abs(i);
            }
            nums[idx] = -1 * nums[idx];
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        System.out.println("Enter the array: ");
        String line = sc.nextLine().trim();

        String[] parts = line.split("\\s+");
        int[] nums = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        int duplicate = sol.findDuplicate(nums);

        if (duplicate != -1) {
            System.out.println("Duplicate number is: " + duplicate);
        } else {
            System.out.println("No duplicate found.");
        }

        sc.close();
    }
}