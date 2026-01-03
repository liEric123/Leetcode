import java.util.*;
class MinStack {
    // Time Complexity: O(1) for all operations
    // Space Complexity: O(N) for the stack. Each element of stack stores value and current min value.
    private Stack<int[]> stack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[] {val, val});
        } else {
            stack.push(new int[] {val, Math.min(val, stack.peek()[1])});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinStack minStack = new MinStack();
        System.out.println("Commands: push <num>, pop, top, getMin, exit");
        
        while (true) {
            System.out.print("Enter command: ");
            String command = sc.next();
            
            if (command.equalsIgnoreCase("push")) {
                int val = sc.nextInt();
                minStack.push(val);
                System.out.println(val + " pushed.");
            } else if (command.equalsIgnoreCase("pop")) {
                minStack.pop();
                System.out.println("Popped top element.");
            } else if (command.equalsIgnoreCase("top")) {
                System.out.println("Top element: " + minStack.top());
            } else if (command.equalsIgnoreCase("getMin")) {
                System.out.println("Minimum element: " + minStack.getMin());
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting.");
                break;
            } else {
                System.out.println("Invalid command.");
            }
        }
        sc.close();
    }
}