import java.util.*;
class Solution {
    public boolean canReach(int[] arr, int start) {
        // Time Complexity: O(N) since we don't visit any index more than once.
        // Space Complexity: O(N) for visited set and BFS queue.
        int n = arr.length;
        Queue<Integer> reach = new ArrayDeque<>();
        reach.offer(start);
        Set<Integer> visitedInd = new HashSet<>();

        while (!reach.isEmpty()) {
            for (int i = 0; i < reach.size(); i++) {
                int currIdx = reach.poll();
                if (arr[currIdx] == 0) {
                    return true;
                }
                if (visitedInd.contains(currIdx)) {
                    continue;
                }
                if (currIdx + arr[currIdx] < n) {
                    reach.offer(currIdx + arr[currIdx]);
                }
                if (currIdx - arr[currIdx] >= 0) {
                    reach.offer(currIdx - arr[currIdx]);
                }
                visitedInd.add(currIdx);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter arr: ");
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Enter start: ");
        int start = sc.nextInt();
    
        System.out.println("Can reach: ");
        System.out.println(new Solution().canReach(arr, start));
    
        sc.close();
    }
}