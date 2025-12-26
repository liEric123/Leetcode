import java.util.*;
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // Time Complexity: O(NLogN) to sort the intervals by start time.
        // Space Complexity: O(1) for a few variables. Note that sorting may take auxiliary space.
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if (currStart < prevEnd) {
                return false;
            }
            prevEnd = currEnd;
        }
        return true;
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
        boolean result = sol.canAttendMeetings(intervals);
        System.out.println("Can attend all meetings: " + result);
        sc.close();
    }
}