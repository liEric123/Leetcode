import java.util.*;
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // Time Complexity: O(log_{M}(N)) where M is numExchange and N is numBottles.
        //                  Each step divides the total bottles by M.
        // Space Complexity: O(1) for a few variables.
        int drunk = 0;
        // While we have at least numExchange empty bottles to exchange.
        while (numBottles >= numExchange) {
            // Total new bottles we can produce to exchange for a full water bottle.
            int totalNew = numBottles / numExchange;
            drunk += numExchange * totalNew;
            numBottles = numBottles - numExchange * totalNew + totalNew;
        }
        return numBottles + drunk;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of bottles: ");
        int numBottles = sc.nextInt();
        System.out.println("Enter the number of exchange: ");
        int numExchange = sc.nextInt();
        Solution sol = new Solution();
        int result = sol.numWaterBottles(numBottles, numExchange);
        System.out.println("The number of bottles drunk is: " + result);
        sc.close();
    }
}