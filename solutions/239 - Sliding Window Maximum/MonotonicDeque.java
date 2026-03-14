import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Time Complexity: O(N) since we loop through all integers once.
        //                  O(1) operation to get each window maximum using monotonic deque.
        // Space Complexity: O(k) auxiliary space for deque that stores at most k elements.
        int[] answer = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                answer[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return answer;
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