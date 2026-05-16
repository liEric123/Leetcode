import java.util.*;
class Solution {
    public int minimumPrefixLength(int[] nums) {
        // Time Complexity: O(N) to scan through the array.
        // Space Complexity: O(1) for a few variables.
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                break;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter nums: ");
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Minimum prefix length: ");
        System.out.println(new Solution().minimumPrefixLength(nums));
    
        sc.close();
    }
}