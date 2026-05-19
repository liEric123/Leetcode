import java.util.*;
class Solution {
    public int minimumOperations(List<Integer> nums) {
        // Time Complexity: O(N) to loop over each number.
        // Space Complexity: O(1) for a few variables.
        int dp1 = 0;
        int dp2 = 0;
        int dp3 = 0;

        for (int i : nums) {
            if (i == 1) {
                dp1++;
            } else if (i == 2) {
                dp2 = Math.max(dp1, dp2) + 1;
            } else {
                dp3 = Math.max(dp1, Math.max(dp2, dp3)) + 1;
            }
        }

        return nums.size() - Math.max(dp1, Math.max(dp2, dp3));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter nums: ");
        List<Integer> nums = new ArrayList<>();
        for (String s : sc.nextLine().split(" ")) {
            nums.add(Integer.parseInt(s));
        }
    
        System.out.println("Minimum operations: ");
        System.out.println(new Solution().minimumOperations(nums));
    
        sc.close();
    }
}