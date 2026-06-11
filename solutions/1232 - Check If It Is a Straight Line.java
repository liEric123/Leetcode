import java.util.*;
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // Time Complexity: O(N) to loop over the coordinates.
        // Space Complexity: O(1) for a few variables.

        int coord1X = coordinates[0][0];
        int coord1Y = coordinates[0][1];
        int coord2X = coordinates[1][0];
        int coord2Y = coordinates[1][1];
        int rise = coord2Y - coord1Y;
        int run = coord2X - coord1X;
        
        for (int i = 2; i < coordinates.length; i++) {
            int currRise = coordinates[i][1] - coord2Y;
            int currRun = coordinates[i][0] - coord2X;
            if (rise * currRun != run * currRise) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter coordinates, empty line to stop: ");
        ArrayList<int[]> list = new ArrayList<>();
    
        while (true) {
            String line = sc.nextLine().trim();
    
            if (line.isEmpty()) {
                break;
            }
    
            String[] parts = line.split(" ");
            list.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
        }
    
        int[][] coordinates = new int[list.size()][2];
    
        for (int i = 0; i < list.size(); i++) {
            coordinates[i] = list.get(i);
        }
    
        Solution sol = new Solution();
        boolean result = sol.checkStraightLine(coordinates);
    
        System.out.println("Is straight line?: ");
        System.out.println(result);
    
        sc.close();
    }
}