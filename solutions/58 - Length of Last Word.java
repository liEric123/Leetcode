import java.util.Scanner;
class Solution {
    public int lengthOfLastWord(String s) {
        // Time Complexity: O(N) to scan over the string. Worst case if String is one word.
        // Space Complexity: O(1) for some variables.
        boolean foundLast = false;
        int lengthLast = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!foundLast && s.charAt(i) != ' ') {
                foundLast = true;
                lengthLast++;
            }
            else if (foundLast) {
                if (s.charAt(i) == ' ') {
                    return lengthLast;
                }
                lengthLast++;
            }
        }
        return lengthLast;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
        Solution sol = new Solution();
        int result = sol.lengthOfLastWord(s);
        System.out.println("Length of last word: " + result);
        sc.close();
    }
}