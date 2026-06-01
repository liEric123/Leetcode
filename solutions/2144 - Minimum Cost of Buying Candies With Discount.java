import java.util.*;
class Solution {
    public int minimumCost(int[] cost) {
        // Time Complexity: O(NLogN) to sort the array.
        // Space Complexity: O(1) to sort the array.
        Arrays.sort(cost);
        
        int totCost = 0;
        for (int i = cost.length - 1; i >= 0; ) {
            totCost += cost[i];
            i--;
            if (i >= 0) {
                totCost += cost[i];
                i--;
            }
            i--;
        }

        return totCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the costs: ");
        String line = sc.nextLine();
    
        String[] parts = line.split(" ");
        int[] cost = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            cost[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int result = sol.minimumCost(cost);
    
        System.out.println("Minimum cost: ");
        System.out.println(result);
    
        sc.close();
    }
}