import java.util.*;
class Solution {
    public int minOperations(String s) {
        // Time Complexity: O(N) to loop over each char in the string.
        // Space Complexity: O(1) for a few variables.
        int startZero = 0;
        int startOne = 0;
        boolean need0 = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (need0) {
                    startOne++;
                } else {
                    startZero++;
                }
            } else {
                if (need0) {
                    startZero++;
                } else {
                    startOne++;
                }
            }
            need0 = !need0;
        }
        return Math.min(startOne, startZero);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the binary string:");
        String s = sc.nextLine().trim();

        Solution sol = new Solution();
        int result = sol.minOperations(s);

        System.out.println("Minimum operations:");
        System.out.println(result);

        sc.close();
    }
}