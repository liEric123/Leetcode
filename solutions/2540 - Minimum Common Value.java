import java.util.*;
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // Time Complexity: O(N + M) to loop over both arrays.
        // Space Complexity: O(1) for a few variables.
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                return nums1[p1];
            }
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter nums1: ");
        int[] nums1 = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Enter nums2: ");
        int[] nums2 = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Common value: ");
        System.out.println(new Solution().getCommon(nums1, nums2));
    
        sc.close();
    }
}