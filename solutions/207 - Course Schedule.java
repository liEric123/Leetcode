import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Time Complexity: O(V + E) to build adjacancy list, dependency array, queue.
        //                  Also, BFS traversal over each node and edge.
        // Space Complexity: O(V + E) for adjacency list, dependency, array, and queue.
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] dependencies = new int[numCourses];
        for (int[] i : prerequisites) {
            adj.get(i[1]).add(i[0]);
            dependencies[i[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < dependencies.length; i++) {
            if (dependencies[i] == 0) {
                queue.offer(i);
            }
        }

        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            coursesTaken++;
            for (int i : adj.get(curr)) {
                dependencies[i]--;
                if (dependencies[i] == 0) {
                    queue.offer(i);
                }
            }

        }

        return coursesTaken == numCourses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter numCourses: ");
        int numCourses = Integer.parseInt(sc.nextLine());
    
        System.out.println("Enter prerequisites (comma-separated pairs): ");
        String line = sc.nextLine();
    
        String[] rows = line.split(",");
        int[][] prerequisites = new int[rows.length][2];
    
        for (int i = 0; i < rows.length; i++) {
            String[] parts = rows[i].trim().split(" ");
            prerequisites[i][0] = Integer.parseInt(parts[0]);
            prerequisites[i][1] = Integer.parseInt(parts[1]);
        }
    
        System.out.println("Can finish?: ");
        System.out.println(new Solution().canFinish(numCourses, prerequisites));
    
        sc.close();
    }
}