import java.util.*;
class Solution {
    public int minCost(String colors, int[] neededTime) {
        // Time Complexity: O(N) to loop through the colors once.
        // Space Complexity: O(1) for a few variables.

        // Remove the max needed time per color group. This minimizes total time.
        int totTime = neededTime[0];
        int maxCurrColorTime = neededTime[0];
        for (int i = 1; i < neededTime.length; i++) {
            totTime += neededTime[i];
            
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                maxCurrColorTime = Math.max(maxCurrColorTime, neededTime[i]);
            } else {
                totTime -= maxCurrColorTime;
                maxCurrColorTime = neededTime[i];
            }
        }
        totTime -= maxCurrColorTime;
        return totTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter colors: ");
        String colors = sc.nextLine().trim();
    
        System.out.println("Enter neededTime: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] neededTime = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            neededTime[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int result = sol.minCost(colors, neededTime);
    
        System.out.println("Minimum time: ");
        System.out.println(result);
    
        sc.close();
    }
}