import java.util.*;
class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // Time Complexity: O(N * M) to test all pairs to find earliest finish.
        // Space Complexity: O(1) for a few variables.
        int earliestTime = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                // Water, then land.
                int waterLandTime = Math.max(waterStartTime[j] + waterDuration[j], landStartTime[i]) +
                                    landDuration[i];

                // Land, then water.
                int landWaterTime = Math.max(landStartTime[i] + landDuration[i], waterStartTime[j]) +
                                    waterDuration[j];
                
                earliestTime = Math.min(earliestTime, Math.min(waterLandTime, landWaterTime));
            }
        }

        return earliestTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter land start times: ");
        String[] landStartParts = sc.nextLine().trim().split("\\s+");
        int[] landStartTime = new int[landStartParts.length];
        for (int i = 0; i < landStartParts.length; i++) {
            landStartTime[i] = Integer.parseInt(landStartParts[i]);
        }
    
        System.out.println("Enter land durations: ");
        String[] landDurationParts = sc.nextLine().trim().split("\\s+");
        int[] landDuration = new int[landDurationParts.length];
        for (int i = 0; i < landDurationParts.length; i++) {
            landDuration[i] = Integer.parseInt(landDurationParts[i]);
        }
    
        System.out.println("Enter water start times: ");
        String[] waterStartParts = sc.nextLine().trim().split("\\s+");
        int[] waterStartTime = new int[waterStartParts.length];
        for (int i = 0; i < waterStartParts.length; i++) {
            waterStartTime[i] = Integer.parseInt(waterStartParts[i]);
        }
    
        System.out.println("Enter water durations: ");
        String[] waterDurationParts = sc.nextLine().trim().split("\\s+");
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