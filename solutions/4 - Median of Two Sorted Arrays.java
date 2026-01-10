import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Time Complexity: O(Log(min(M, N))) because we binary search over the smaller array.
        //                  We change the partition point in the smaller array unitl median is found.
        // Space Complexity: O(1) for a few variables.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // ensure l1 is always the smaller array.
        int l1 = nums1.length;
        int l2 = nums2.length;
        int half = (l1 + l2 + 1) / 2;
        boolean even = (l1 + l2) % 2 == 0;
        int left = 0;
        int right = l1;
        while (left <= right) {
            int partitionSmall = left + (right - left) / 2;
            int partitionLarge = half - partitionSmall;
            int left1 = partitionSmall == 0 ? Integer.MIN_VALUE : nums1[partitionSmall - 1];
            int right1 = partitionSmall == l1 ? Integer.MAX_VALUE : nums1[partitionSmall];
            int left2 = partitionLarge == 0 ? Integer.MIN_VALUE : nums2[partitionLarge - 1];
            int right2 = partitionLarge == l2 ? Integer.MAX_VALUE : nums2[partitionLarge];
            if (left1 <= right2 && left2 <= right1) {
                // if even, find average
                if (even) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
                // if odd, do what?
                return Math.max(left1, left2);
            }
            // move partition point in smaller array
            if (left1 > right2) {
                right = partitionSmall - 1;
            } else {
                left = partitionSmall + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first sorted array: ");
        String line1 = sc.nextLine().trim();
        String[] parts1 = line1.isEmpty() ? new String[0] : line1.split("\\s+");
        int[] nums1 = new int[parts1.length];
        for (int i = 0; i < parts1.length; i++) {
            nums1[i] = Integer.parseInt(parts1[i]);
        }

        System.out.println("Enter second sorted array: ");
        String line2 = sc.nextLine().trim();
        String[] parts2 = line2.isEmpty() ? new String[0] : line2.split("\\s+");
        int[] nums2 = new int[parts2.length];
        for (int i = 0; i < parts2.length; i++) {
            nums2[i] = Integer.parseInt(parts2[i]);
        }

        Solution solution = new Solution();
        double median = solution.findMedianSortedArrays(nums1, nums2);

        System.out.println("Median: " + median);
        sc.close();
    }
}