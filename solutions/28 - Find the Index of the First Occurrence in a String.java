import java.util.Scanner;
class Solution {
    public int strStr(String haystack, String needle) {
        // Time Complexity: O(N * M) because we loop through each char of the haystack once.
        //                  Creating each substring takes O(M).
        // Space Complexity: O(M) for the substrings.
        int size = haystack.length() - needle.length();
        for (int i = 0; i <= size; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter haystack: ");
        String haystack = sc.nextLine();

        System.out.print("Enter needle: ");
        String needle = sc.nextLine();

        Solution solution = new Solution();
        int result = solution.strStr(haystack, needle);

        System.out.println("Output: " + result);
        sc.close();
    }
}