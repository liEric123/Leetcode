import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Time Complexity: O(N) to loop through each day.
        //                  If we reach a warmer day, we process past days in stack.
        // Space Complexity: O(N) for stack. Worst case each day is colder than the last.
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter temperatures: ");
        String line = sc.nextLine();

        String[] parts = line.trim().split("\\s+");
        int[] temperatures = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            temperatures[i] = Integer.parseInt(parts[i]);
        }

        Solution sol = new Solution();
        int[] result = sol.dailyTemperatures(temperatures);

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
        
        sc.close();
    }
}