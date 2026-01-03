import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        // Time Complexity: O(N) to loop through all the tokens.
        // Space Complexity: O(N) for stack.
        Stack<String> stack = new Stack<>();
        String ops = "+-*/";
        for (String s : tokens) {
            if (ops.contains(s)) {
                int two = Integer.parseInt(stack.pop());
                int one = Integer.parseInt(stack.pop());
                switch (s) {
                    case "+":
                        stack.push(Integer.toString(one + two));
                        break;
                    case "-":
                        stack.push(Integer.toString(one - two));
                        break;
                    case "*":
                        stack.push(Integer.toString(one * two));
                        break;
                    case "/":
                        stack.push(Integer.toString(one / two));
                        break;
                }
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.println("Enter an RPN expression: ");
        String input = sc.nextLine();

        String[] tokens = input.trim().split("\\s+");

        int result = sol.evalRPN(tokens);
        System.out.println("Result: " + result);

        sc.close();
    }
}