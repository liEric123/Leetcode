import java.util.*;
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Time Complexity: O(LogN) for the 2 binary searches to find the extremes.
        // Space Complexity: O(1) for a few variables.
        int l = 0;
        int r = nums.length - 1;
        boolean found = false;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                found = true;
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int first = l;

        if (!found) {
            return new int[]{-1, -1};
        }

        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                l = m + 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int last = r;

        return new int[]{first, last};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter nums: ");
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Enter target: ");
        int target = sc.nextInt();
    
        System.out.println("Range: ");
        System.out.println(Arrays.toString(new Solution().searchRange(nums, target)));
    
        sc.close();
    }
}