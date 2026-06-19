import java.util.*;
class Solution {
    public int largestAltitude(int[] gain) {
        // Time Complexity: O(N) to loop through the points.
        // Space Complexity: O(1) for a few variables.
        int altitude = 0;
        int largestAltitude = 0;
        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            largestAltitude = Math.max(largestAltitude, altitude);
        }

        return largestAltitude;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter gain array: ");
        String line = sc.nextLine();
    
        String[] parts = line.split(" ");
        int[] gain = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            gain[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int result = sol.largestAltitude(gain);
    
        System.out.println("Largest altitude: ");
        System.out.println(result);
    
        sc.close();
    }
}