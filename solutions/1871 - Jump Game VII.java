import java.util.*;
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        // Time Complexity: O(N) because each index can be visited only once. We only search forward.
        // Space Complexity: O(N) for visited array and queue.
        boolean[] visited = new boolean[s.length()];
        visited[0] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int reachable = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == s.length() - 1) {
                return true;
            }

            int start = curr + minJump;
            int end = curr + maxJump;

            if (start < reachable) {
                start = reachable;
            }
            if (end >= s.length()) {
                end = s.length() - 1;
            }

            for (int i = start; i <= end && i < s.length(); i++) {
                if (s.charAt(i) == '0' && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }

            if (end > reachable) {
                reachable = end;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
    
        System.out.println("Enter minJump: ");
        int minJump = sc.nextInt();
    
        System.out.println("Enter maxJump: ");
        int maxJump = sc.nextInt();
    
        Solution sol = new Solution();
        boolean result = sol.canReach(s, minJump, maxJump);
    
        System.out.println("Can reach end: ");
        System.out.println(result);
    
        sc.close();
    }
}