import java.util.*;
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Time Complexity: O(NLogN) to sort the start and end times of the intervals.
        // Space Complexity: O(N) for start and end time arrays.
        int answer = 0;
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];
        int idx = 0;
        for (int[] i : intervals) {
            startTimes[idx] = i[0];
            endTimes[idx++] = i[1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int start = 0, end = 0;
        int meetingsCount = 0;
        while (start < startTimes.length && end < endTimes.length) {
            if (startTimes[start] < endTimes[end]) {
                meetingsCount++;
                start++;
            } else {
                meetingsCount--;
                end++;
            }
            answer = Math.max(answer, meetingsCount);
        }
        return answer;
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
        int result = sol.minMeetingRooms(intervals);
        System.out.println("Minimum number of meeting rooms needed: " + result);
        sc.close();
    }
}