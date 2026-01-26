import java.util.*;
class Solution {
    public boolean isSubsequence(String s, String t) {
        // Time Complexity: O(N) to loop through t to find if s is a subsequence.
        //                  We greedily select each char because relative positions can't change.
        // Space Complexity: O(1) for a few variables.
        int buildIdx = 0;
        for (int i = 0; i < t.length() && buildIdx < s.length(); i++) {
            if (t.charAt(i) == s.charAt(buildIdx)) {
                buildIdx++;
            }
            if (buildIdx == s.length()) {
                return true;
            }
        }
        return buildIdx == s.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string s: ");
        String s = sc.nextLine();
        System.out.println("Enter the string t: ");
        String t = sc.nextLine();
        Solution sol = new Solution();
        System.out.println("Is s a subsequence of t?: " + sol.isSubsequence(s, t));
        sc.close();
    }
}