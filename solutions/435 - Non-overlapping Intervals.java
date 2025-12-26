import java.util.*;
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Time Complexity: O(NLogN) for sorting intervals by start.
        //                  All other processes are O(N).
        // Space Complexity: O(1) extra space for a few variables.
        //                   Note sorting uses auxiliary space.
        int remove = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int leastEnd = intervals[0][1];
        for (int[] i : intervals) {
            if (i == intervals[0]) continue;
            int currStart = i[0];
            int currEnd = i[1];
            if (currStart >= leastEnd) {
                leastEnd = currEnd;
            } else {
                remove++;
                leastEnd = Math.min(currEnd, leastEnd);
            }
        }
        return remove;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        System.out.println("Enter the number of intervals: ");
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        System.out.println("Enter the intervals: ");
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int result = sol.eraseOverlapIntervals(intervals);
        System.out.println("Number of intervals to remove: " + result);
        sc.close();
    }
}