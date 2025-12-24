import java.util.*;
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Time Complexity: O(N) to loop over all the intervals once deciding what to do with each.
        // Space Complexity: O(N) for output List and array, but O(1) extra space.
        if (intervals == null || intervals.length == 0) {
            return new int[][] {newInterval};
        }
        List<int[]> answerList = new ArrayList<>();
        boolean flag = false;
        for (int[] i : intervals) {
            if (newInterval[0] > i[1]) {
                answerList.add(i);
            } else if (!flag && newInterval[1] < i[0]) {
                answerList.add(newInterval);
                answerList.add(i);
                flag = true;
            } else if (!flag) {
                newInterval[0] = Math.min(i[0], newInterval[0]);
                newInterval[1] = Math.max(i[1], newInterval[1]);
            } else {
                answerList.add(i);
            }
        }
        if (!flag) {
            answerList.add(newInterval);
        }
        int[][] answer = new int[answerList.size()][];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.println("Enter number of intervals: ");
        int n = sc.nextInt();

        int[][] intervals = new int[n][2];

        System.out.println("Enter the intervals: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Interval " + (i + 1) + ": ");
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        int[] newInterval = new int[2];
        System.out.println("Enter the new interval: ");
        newInterval[0] = sc.nextInt();
        newInterval[1] = sc.nextInt();

        int[][] result = sol.insert(intervals, newInterval);

        System.out.println("Resulting intervals: ");
        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        sc.close();
    }
}