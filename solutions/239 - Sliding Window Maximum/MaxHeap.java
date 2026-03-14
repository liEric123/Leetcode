import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Time Complexity: O(NLogN) because each element may be inserted/removed from heap.
        // Space Complexity: O(N) because heap may store up to N elements in worse case.
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(new int[]{nums[i], i});
            // [i - k + 1, i]
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the numbers: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        System.out.println("Enter k:");
        int k = sc.nextInt();

        Solution sol = new Solution();
        int[] result = sol.maxSlidingWindow(nums, k);

        System.out.println("Sliding window maximum:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        sc.close();
    }
}