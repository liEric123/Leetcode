import java.util.*;
class Solution {
    public int numSteps(String s) {
        // Time Complexity: O(N) to loop over the integer.
        // Space Complexity: O(1) for a few variables.

        // Sample: 1101
        // Start with right 1. Odd -> Add 1 -> Even -> Divide by 2.
        // 13 + 1 = 14 / 2 = 7 = 111
        // 111 = 110 + 1 (carry)
        // Now on 110. Even so divide by 2. 6 / 2 = 3.
        // No carry so we have 11 + 0.
        // Now on 11. Odd -> Add 1 -> Even -> Divide by 2.
        // 3 + 1 = 4 / 2 = 2.
        // 1 + 1 (carry) = 10.
        // Now on 10. Even -> divide by 2 = 1.
        // We get 1 and there is no carry so we are done.
        int totSteps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            char curr = s.charAt(i);

            if (curr == '0' && carry == 0) {
                totSteps++;
                carry = 0;
            } else if (curr == '0' && carry == 1) {
                totSteps += 2;
                carry = 1;
            } else if (curr == '1' && carry == 0) {
                totSteps += 2;
                carry = 1;
            } else if (curr == '1' && carry == 1) {
                totSteps += 1;
                carry = 1;
            }
        }

        return totSteps + carry;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the binary string: ");
        String s = sc.nextLine();
    
        Solution sol = new Solution();
        int result = sol.numSteps(s);
    
        System.out.println("Number of steps: ");
        System.out.println(result);
    
        sc.close();
    }
}