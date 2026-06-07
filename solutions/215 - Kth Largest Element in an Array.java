import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Time Complexity: O(N * Logk) because for each element heap operations are O(Logk).
        // Space Complexity: O(K) for the heap which can have up to k elements in it.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums) {
            minHeap.offer(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array: ");
        String line = sc.nextLine();
    
        String[] parts = line.split(" ");
        int[] nums = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
    
        System.out.println("Enter k: ");
        int k = Integer.parseInt(sc.nextLine().trim());
    
        Solution sol = new Solution();
        int result = sol.findKthLargest(nums, k);
    
        System.out.println("Kth largest element: ");
        System.out.println(result);
    
        sc.close();
    }
}