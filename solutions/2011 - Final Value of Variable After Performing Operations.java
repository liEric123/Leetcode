import java.util.*;
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        // Time Complexity: O(N) to loop through all operations.
        // Space Complexity: O(1) for the variable.
        int val = 0;
        
        for (String s : operations) {
            switch(s) {
                case "++X":
                case "X++":
                    val++;
                    break;
                case "--X":
                case "X--":
                    val--;
                    break;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the operations: ");
        String inputLine = sc.nextLine();

        String[] operations = inputLine.trim().split("\\s+");

        Solution sol = new Solution();
        int result = sol.finalValueAfterOperations(operations);

        System.out.println("The final value after performing all operations is: " + result);

        sc.close();
    }
}