import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        // Time Complexity: O(NLogN) for sorting the intervals by start time.
        //                  All other processes are O(N).
        // Space Complexity: O(N) for output array and list.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> answerList = new ArrayList<>();
        answerList.add(intervals[0]);
        for (int[] i : intervals) {
            int prevEnd = answerList.get(answerList.size() - 1)[1];
            int currStart = i[0];
            int currEnd = i[1];
            if (prevEnd >= currStart) {
                answerList.get(answerList.size() - 1)[1] = Math.max(currEnd, prevEnd);
            } else {
                answerList.add(i);
            }
        }
        int[][] answer = new int[answerList.size()][];
        int idx = 0;
        for (int[] i : answerList) {
            answer[idx++] = i;
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
        int[][] result = sol.merge(intervals);
        System.out.println("Merged intervals: ");
        for (int[] i : result) {
            System.out.println(i[0] + " " + i[1]);
        }
        sc.close();
    }
}