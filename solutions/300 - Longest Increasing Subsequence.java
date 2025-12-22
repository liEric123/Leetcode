import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
        // Time Complexity: O(N^2) because for each element we compare it with all previous elements
        //                         to see if we can extend the longest subsequence.
        // Space Complexity: O(N) for longest dp array.
        int[] longest = new int[nums.length];
        Arrays.fill(longest, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && longest[i] <= longest[j]) {
                    longest[i] = longest[j] + 1;
                }
            }
        }
        int maxi = Integer.MIN_VALUE;
        for (int i : longest) {
            maxi = Math.max(maxi, i);
        }
        return maxi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter numbers separated by spaces:");
        String line = sc.nextLine();

        String[] parts = line.split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        Solution sol = new Solution();
        System.out.println(sol.lengthOfLIS(nums));
        sc.close();
    }
}