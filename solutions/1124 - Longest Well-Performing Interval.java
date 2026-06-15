import java.util.*;
class Solution {
    public int longestWPI(int[] hours) {
        // Time Complexity: O(N) to convert hours into +1/-1, build prefix sum array,
        //                  build monotonic stack, and find the maximum interval.
        //                  Each interval is pushed and popped from the stack at most once.
        // Space Complexity: O(N) for the prefix sum array and stack.

        // Convert raw hours into boolean like number for prefix sums.
        for (int i = 0; i < hours.length; i++) {
            hours[i] = (hours[i] > 8) ? 1 : -1;
        }
        
        // prefix(i) represents the sum [0, i] of the transformed array.
        int[] prefix = new int[hours.length + 1];
        prefix[0] = 0;
        for (int i = 1; i <= hours.length; i++) {
            prefix[i] = prefix[i - 1] + hours[i - 1];
        }

        // Build monotonically decreasing stack.
        // These represent the best starting days for the interval.
        Stack<Integer> best = new Stack<>();
        for (int i = 0; i < prefix.length; i++) {
            if (best.isEmpty() || prefix[best.peek()] > prefix[i]) {
                best.push(i);
            }
        }

        int longest = 0;
        for (int i = prefix.length - 1; i >= 0; i--) {
            // Keep popping if we can extend current interval.
            // We loop from right to left to maximize each interval's length.
            while (!best.isEmpty() && prefix[i] > prefix[best.peek()]) {
                longest = Math.max(longest, i - best.pop());
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter hours: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] hours = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            hours[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int result = sol.longestWPI(hours);
    
        System.out.println("Longest well-performing interval: ");
        System.out.println(result);
    
        sc.close();
    }
}