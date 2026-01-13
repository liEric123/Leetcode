import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        // Time Complexity: O(N) since slow and fast pointers meet up in the cycle.
        //                  The cycle is at most of size N.
        //                  Fast catches slow in no more than one cycle.
        //                  Finding the cycle entrance takes at most one cycle.
        //                  This is because we start the pointers in the cycle.
        // Space Complexity: O(1) for a few pointers. We do not modify input array.
        // Find intersection which will be in the cycle.
        int slow = nums[0];
        int fast = nums[0];
        // use do-while because slow and fast start on same index.
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // Now that intersection is found, reset pointer and find cycle.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        // Both pointers are on the duplicate number
        return slow;
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