import java.util.*;
class Solution {
    public boolean checkOnesSegment(String s) {
        // Time Complexity: O(N) to loop through the string checking for the invalid substring.
        // Space Complexity: O(1) for a few variables.
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(i, i + 2).equals("01")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the binary string: ");
        String s = sc.nextLine();
    
        Solution sol = new Solution();
        boolean result = sol.checkOnesSegment(s);
    
        System.out.println("Has at most one segment of ones?: ");
        System.out.println(result);
    
        sc.close();
    }
    
}