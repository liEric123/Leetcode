import java.util.*;
class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // Time Complexity: O(N) to loop over the ghosts, finding the Manhattan distance.
        // Space Complexity: O(1) for a few variables.
        int xTarget = target[0];
        int yTarget = target[1];
        int timeToTarget = Math.abs(xTarget) + Math.abs(yTarget);

        for (int[] i : ghosts) {
            int xGhost = i[0];
            int yGhost = i[1];
            int timeToTargetGhost = Math.abs(xTarget - xGhost) + Math.abs(yTarget - yGhost);
            if (timeToTargetGhost <= timeToTarget) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter ghosts, empty line to stop: ");
        ArrayList<int[]> ghostList = new ArrayList<>();
    
        while (true) {
            String line = sc.nextLine().trim();
    
            if (line.isEmpty()) {
                break;
            }
    
            String[] parts = line.split("\\s+");
            int[] ghost = new int[2];
            ghost[0] = Integer.parseInt(parts[0]);
            ghost[1] = Integer.parseInt(parts[1]);
            ghostList.add(ghost);
        }
    
        int[][] ghosts = ghostList.toArray(new int[ghostList.size()][]);
    
        System.out.println("Enter target: ");
        String[] targetParts = sc.nextLine().trim().split("\\s+");
        int[] target = new int[2];
        target[0] = Integer.parseInt(targetParts[0]);
        target[1] = Integer.parseInt(targetParts[1]);
    
        Solution sol = new Solution();
        boolean result = sol.escapeGhosts(ghosts, target);
    
        System.out.println("Can escape: ");
        System.out.println(result);
    
        sc.close();
    }
}