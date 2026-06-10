import java.util.*;
class Solution {
    public int balancedStringSplit(String s) {
        // Time Complexity: O(N) to loop over the string.
        // Space Complexity: O(1) for a few variables.

        int balance = s.charAt(0) == 'R' ? 1 : -1;
        int totBalanced = 0;

        for (int i = 1; i < s.length(); i++) {
            balance += s.charAt(i) == 'R' ? 1 : -1;
            if (balance == 0) {
                totBalanced++;
            }
        }

        return totBalanced;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
    
        Solution sol = new Solution();
        int result = sol.balancedStringSplit(s);
    
        System.out.println("Number of balanced strings: ");
        System.out.println(result);
    
        sc.close();
    }
}