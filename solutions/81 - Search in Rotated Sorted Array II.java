import java.util.*;
class Solution {
    public boolean search(int[] nums, int target) {
        // Time Complexity: O(LogN) average for binary search.
        //                  O(N) when many duplicates.
        // Space Complexity: O(1) for a few variables.
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return true;
            }
            if (nums[m] == nums[l] && nums[m] == nums[r]) {
                r--;
                l++;
            } else if (nums[m] >= nums[l]) {
                if (nums[m] > target && nums[l] <= target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target && nums[r] >= target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter nums: ");
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Enter target: ");
        int target = sc.nextInt();
    
        System.out.println("Found: ");
        System.out.println(new Solution().search(nums, target));
    
        sc.close();
    }
}