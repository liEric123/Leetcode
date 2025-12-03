import java.util.HashMap;
import java.util.Scanner;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Time Complexity: O(N) because we use sliding window.
        //                  HashMap operations are O(1).
        // Space Complexity: O(1) because bounded by number of unique chars.
        HashMap<Character, Integer> set = new HashMap<>();
        int ans = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            Character curr = s.charAt(i);
            if (set.containsKey(s.charAt(i))) {
                j = Math.max(set.get(curr) + 1, j);
            }
            ans = Math.max(ans, i - j + 1);
            set.put(curr, i);
            // System.out.println(j + " " + i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.println("Enter a string to test longest substring without repeating characters:");
        String input = sc.nextLine();

        int result = sol.lengthOfLongestSubstring(input);
        System.out.println("Input String: " + input);
        System.out.println("Longest Substring Length: " + result);
    }
}