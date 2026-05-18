import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        // Time Complexity: O(N) to loop over all prices.
        // Space Complexity: O(1) for a few variables.
        int maxProfit = 0;
        int mini = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - mini);
            mini = Math.min(mini, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter prices: ");
        int[] prices = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Maximum profit: ");
        System.out.println(new Solution().maxProfit(prices));
    
        sc.close();
    }
}