import java.util.*;
class Solution {
    public int minPairSum(int[] nums) {
        // Time Complexity: O(NlogN) to sort the array.
        // Space Complexity: O(1) for a few variable and sorting.
        Arrays.sort(nums);
        int maxPairSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length / 2; i++) {
            maxPairSum = Math.max(maxPairSum, nums[i] + nums[nums.length - 1 - i]);
        }

        return maxPairSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter nums: ");
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Minimized maximum pair sum: ");
        System.out.println(new Solution().minPairSum(nums));
    
        sc.close();
    }
}