import java.util.*;
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // Time Complexity: O(N + M) to find the minimum ending times and check possible pairs.
        // Space Complexity: O(1) for a few variables.
        int landEndMin = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            landEndMin = Math.min(landEndMin, landStartTime[i] + landDuration[i]);
        }
        
        int waterEndMin = Integer.MAX_VALUE;
        for (int j = 0; j < waterStartTime.length; j++) {
            waterEndMin = Math.min(waterEndMin, waterStartTime[j] + waterDuration[j]);
        }

        int earliestFinish = Integer.MAX_VALUE;
        // Take land then water. 
        for (int i = 0; i < waterStartTime.length; i++) {
            int currTime = Math.max(landEndMin, waterStartTime[i]) + waterDuration[i];
            earliestFinish = Math.min(earliestFinish, currTime);
        }

        // Take water then land.
        for (int i = 0; i < landStartTime.length; i++) {
            int currTime = Math.max(waterEndMin, landStartTime[i]) + landDuration[i];
            earliestFinish = Math.min(earliestFinish, currTime);
        }

        return earliestFinish;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter land start times: ");
        String[] landStartParts = sc.nextLine().split(" ");
        int[] landStartTime = new int[landStartParts.length];
        for (int i = 0; i < landStartParts.length; i++) {
            landStartTime[i] = Integer.parseInt(landStartParts[i]);
        }
    
        System.out.println("Enter land durations: ");
        String[] landDurationParts = sc.nextLine().split(" ");
        int[] landDuration = new int[landDurationParts.length];
        for (int i = 0; i < landDurationParts.length; i++) {
            landDuration[i] = Integer.parseInt(landDurationParts[i]);
        }
    
        System.out.println("Enter water start times: ");
        String[] waterStartParts = sc.nextLine().split(" ");
        int[] waterStartTime = new int[waterStartParts.length];
        for (int i = 0; i < waterStartParts.length; i++) {
            waterStartTime[i] = Integer.parseInt(waterStartParts[i]);
        }
    
        System.out.println("Enter water durations: ");
        String[] waterDurationParts = sc.nextLine().split(" ");
        int[] waterDuration = new int[waterDurationParts.length];
        for (int i = 0; i < waterDurationParts.length; i++) {
            waterDuration[i] = Integer.parseInt(waterDurationParts[i]);
        }
    
        Solution sol = new Solution();
        int result = sol.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
    
        System.out.println("Earliest finish time: ");
        System.out.println(result);
    
        sc.close();
    }
}