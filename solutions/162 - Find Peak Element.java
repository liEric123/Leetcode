import java.util.*;
class Solution {
    public int findPeakElement(int[] nums) {
        // Time Complexity: O(LogN) because we can use binary search.
        // Space Complexity: O(1) for a few variables.
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter integers: ");
        String input = sc.nextLine();

        String[] parts = input.trim().split("\\s+");
        int[] nums = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        Solution sol = new Solution();
        int peakIndex = sol.findPeakElement(nums);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + nums[peakIndex]);

        sc.close();
    }
}