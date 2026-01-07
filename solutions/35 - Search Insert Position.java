import java.util.*;
class Solution {
    public int searchInsert(int[] nums, int target) {
        // Time Complexity: O(LogN) because the array is divided in half each time.
        // Space Complexity: O(1) for a few variables.
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the sorted array: ");
        String[] input = sc.nextLine().trim().split("\\s+");
        int[] nums = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        System.out.println("Enter the target value: ");
        int target = sc.nextInt();

        Solution sol = new Solution();
        int result = sol.searchInsert(nums, target);

        System.out.println("Insert position: " + result);
        sc.close();
    }
}