import java.util.*;
class Solution {
    public int minJumps(int[] arr) {
        // Time Complexity: O(N) to build the mapping and BFS traversal of array.
        // Space Complexity: O(N) for the map and visited array and queue.
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            
            map.get(arr[i]).add(i);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int curr = queue.poll();
                if (curr == arr.length - 1) {
                    return steps;
                }

                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    queue.offer(curr - 1);
                    visited[curr - 1] = true;
                }

                if (curr + 1 < arr.length && !visited[curr + 1]) {
                    queue.offer(curr + 1);
                    visited[curr + 1] = true;
                }

                List<Integer> same = map.get(arr[curr]);
                for (int j : same) {
                    if (!visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                    }
                }
                same.clear();
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter arr: ");
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Minimum jumps: ");
        System.out.println(new Solution().minJumps(arr));
    
        sc.close();
    }
}