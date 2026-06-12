import java.util.*;
class Solution {
    public int minCost(int[][] costs) {
        // Time Complexity: O(N) to loop over each house once.
        // Space Complexity: O(1) for a few variables.

        // Store the min cost to paint the previous house with a chosen color.
        int prevHouseRed = costs[0][0];
        int prevHouseGreen = costs[0][1];
        int prevHouseBlue = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int currRed = costs[i][0];
            int currGreen = costs[i][1];
            int currBlue = costs[i][2];

            // Use a temporary variable because we can't edit prevHouse variables yet.
            int currHouseRed = currRed + Math.min(prevHouseGreen, prevHouseBlue);
            int currHouseGreen = currGreen + Math.min(prevHouseRed, prevHouseBlue);
            int currHouseBlue = currBlue + Math.min(prevHouseRed, prevHouseGreen);

            prevHouseRed = currHouseRed;
            prevHouseGreen = currHouseGreen;
            prevHouseBlue = currHouseBlue;
        }

        // Return the min cost to paint the last house.
        return Math.min(prevHouseRed, Math.min(prevHouseGreen, prevHouseBlue));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter costs, empty line to stop: ");
        ArrayList<int[]> costList = new ArrayList<>();
    
        while (true) {
            String line = sc.nextLine().trim();
    
            if (line.isEmpty()) {
                break;
            }
    
            String[] parts = line.split("\\s+");
            int[] row = new int[3];
    
            for (int i = 0; i < 3; i++) {
                row[i] = Integer.parseInt(parts[i]);
            }
    
            costList.add(row);
        }
    
        int[][] costs = costList.toArray(new int[costList.size()][]);
    
        Solution sol = new Solution();
        int result = sol.minCost(costs);
    
        System.out.println("Minimum cost: ");
        System.out.println(result);
    
        sc.close();
    }
}