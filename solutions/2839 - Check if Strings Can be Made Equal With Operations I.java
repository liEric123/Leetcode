import java.util.*;
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // Time Complexity: O(1) for constant number of checks. 
        // Space Complexity: O(1) for constant number of checks.
        if (((s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
             (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0))) &&
            ((s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
             (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1)))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter s1: ");
        String s1 = sc.nextLine();

        System.out.println("Enter s2: ");
        String s2 = sc.nextLine();

        Solution sol = new Solution();
        boolean result = sol.canBeEqual(s1, s2);

        System.out.println("Can be equal: ");
        System.out.println(result);

        sc.close();
    }
}