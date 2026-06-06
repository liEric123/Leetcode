import java.util.*;
class Solution {
    public int[] leftRightDifference(int[] nums) {
        // Time Complexity: O(N) to loop over the array making the left and right sums.
        //                  Also to fill out the answer.
        // Space Complexity: O(N) for the left and right sum arrays.
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] += i - 1 >= 0 ? left[i - 1] + nums[i - 1] : 0;
            int j = n - 1 - i;
            right[j] += n - i < n ? right[n - i] + nums[n - i] : 0;
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int diff = left[i] - right[i];
            answer[i] = diff > 0 ? diff : -diff;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] nums = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int[] result = sol.leftRightDifference(nums);
    
        System.out.println("Left right difference: ");
        System.out.println(Arrays.toString(result));
    
        sc.close();
    }
}