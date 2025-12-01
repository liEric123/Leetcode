import java.util.Scanner;
class Solution {
    public String longestPalindrome(String s) {
        // Time Complexity: O(N^2) because for every letter we try to build palindromes of even and odd length.
        // Space Complexity: O(1) because we only store pointers and constants.
        int lenLongest = 0;
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            // odd number
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > lenLongest) {
                    lenLongest = r - l + 1;
                    longest = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > lenLongest) {
                    lenLongest = r - l + 1;
                    longest = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        System.out.println("Enter a string to find the longest palindromic substring:");
        String s = sc.nextLine();
        String result = sol.longestPalindrome(s);
        System.out.println("The longest palindromic substring is: " + result);
    }
}