import java.util.*;
class Solution {
    public int calPoints(String[] operations) {
        // Time Complexity: O(N) to loop through the operations.
        // Space Complexity: O(N) for the stack worse case.
        Stack<Integer> stack = new Stack<>();
        for (String s : operations) {
            if (s.equals("+")) {
                int prev1 = stack.pop();
                int prev2 = stack.pop();
                stack.push(prev2);
                stack.push(prev1);
                stack.push(prev1 + prev2);
            } else if (s.equals("D")) {
                int prev1 = stack.pop();
                stack.push(prev1);
                stack.push(2 * prev1);
            } else if (s.equals("C")) {
                stack.pop();
            } else {
                int newScore = Integer.parseInt(s);
                stack.push(newScore);
            }
        }
        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the operations: ");
        String[] operations = sc.nextLine().split(" ");
        Solution sol = new Solution();
        int result = sol.calPoints(operations);
        System.out.println("The total score is: " + result);
        sc.close();
    }
}