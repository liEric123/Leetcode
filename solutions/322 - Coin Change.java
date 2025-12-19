import java.util.Scanner;
class Solution {
    public int coinChange(int[] coins, int amount) {
        // Time Complexity: O(N * M) where N is the target amount and M is the number of coins.
        // Space Complexity: O(N) for dp array.
        if (amount == 0) {
            return 0;
        }
        int[] nums = new int[amount + 1];
        nums[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0 && nums[i - c] < amount) {
                    nums[i] = Math.min(nums[i], nums[i - c] + 1);
                }
            }
        }
        return nums[amount] != Integer.MAX_VALUE ? nums[amount] : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter coin values separated by spaces:");
        String line = sc.nextLine();
        String[] parts = line.split(" ");
        int[] coins = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            coins[i] = Integer.parseInt(parts[i]);
        }
        System.out.println("Enter the target amount:");
        int amount = sc.nextInt();

        Solution sol = new Solution();
        int result = sol.coinChange(coins, amount);
        System.out.println("Minimum number of coins needed: " + result);

        sc.close();
    }
}