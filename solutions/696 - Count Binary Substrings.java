import java.util.*;
class Solution {
    public int countBinarySubstrings(String s) {
        // Time Complexity: O(N) for a single scan over input string.
        // Space Complexity: O(1) for a few variables.
        int currGroupLen = 1;
        int prevGroupLen = 0;
        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroupLen++;
            } else {
                prevGroupLen = currGroupLen;
                currGroupLen = 1;
            }
            if (prevGroupLen >= currGroupLen) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the binary string: ");
        String s = sc.nextLine().trim();

        Solution sol = new Solution();
        int result = sol.countBinarySubstrings(s);

        System.out.println("Count of binary substrings: ");
        System.out.println(result);

        sc.close();
    }
}