import java.util.*;
class Solution {
    public int missingNumber(int[] nums) {
        // Time Complexity: O(N) to loop through the array once.
        // Space Complexity: O(1) for a few variables.
        int answer = nums.length;
        for (int i = 0; i < nums.length; i++) {
            answer ^= i ^ nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers: ");
        String[] numsStr = sc.nextLine().split(" ");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        Solution solution = new Solution();
        System.out.println("The missing number is: " + solution.missingNumber(nums));
        sc.close();
    }
}