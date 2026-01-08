import java.util.*;
class Solution {
    public boolean buddyStrings(String s, String goal) {
        // Time Complexity: O(N) to loop through the strings and make frequency arrays.
        // Space Complexity: O(1) for the two frequency arrays and variables.
        if (s.length() != goal.length()) {
            return false;
        }
        int[] sCounts = new int[26];
        int[] goalCounts = new int[26];
        int differCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int currSChar = s.charAt(i);
            int currGoalChar = goal.charAt(i);
            sCounts[currSChar - 'a']++;
            goalCounts[currGoalChar - 'a']++;
            if (currSChar != currGoalChar) {
                differCount++;
            }
        }
        boolean moreThanOne = false;
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != goalCounts[i]) {
                return false;
            }
            if (sCounts[i] > 1) {
                moreThanOne = true;
            }
        }
        if (differCount == 2 || (differCount == 0 && moreThanOne == true)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first string:");
        String s = sc.nextLine();

        System.out.println("Enter second string:");
        String goal = sc.nextLine();

        Solution sol = new Solution();
        System.out.println("Result: " + sol.buddyStrings(s, goal));

        sc.close();
    }
}