import java.util.Scanner;
class Solution {
    public int maxProduct(int[] nums) {
        // Time Complexity: O(N) because we loop through the array once.
        // Space Complexity: O(1) for a couple of variables.
        int mini = nums[0];
        int maxi = nums[0];
        int answer = maxi;
        for (int i = 1; i < nums.length; i++) {
            int tempMin = mini;
            int tempMax = maxi;
            mini = Math.min(nums[i], Math.min(tempMin * nums[i], tempMax * nums[i]));
            maxi = Math.max(nums[i], Math.max(tempMin * nums[i], tempMax * nums[i]));
            answer = Math.max(answer, maxi);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integers separated by spaces:");
        String line = sc.nextLine();
        String[] parts = line.trim().split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(nums));
        sc.close();
    }
}