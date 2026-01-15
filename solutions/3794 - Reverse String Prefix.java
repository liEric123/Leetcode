import java.util.*;
class Solution {
    public String reversePrefix(String s, int k) {
        // Time Complexity: O(N) to build the resulting string.
        // Space Complexity: O(N) for the resulting string.
        String sub = s.substring(0, k);
        String ending = s.substring(k);
        String reversed = new StringBuilder(sub).reverse().toString();
        return reversed + ending;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.println("Enter a string:");
        String s = sc.nextLine();

        System.out.println("Enter k:");
        int k = sc.nextInt();

        String result = sol.reversePrefix(s, k);
        System.out.println("Result: " + result);

        sc.close();
    }
}