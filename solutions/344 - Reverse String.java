import java.util.*;
class Solution {
    public void reverseString(char[] s) {
        // Time Complexity: O(N) to loop through half the string.
        // Space Complexity: O(1) because we modify array in place.
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
        char[] sArray = s.toCharArray();
        Solution sol = new Solution();
        sol.reverseString(sArray);
        System.out.println("The reversed string is: " + new String(sArray));
        sc.close();
    }
}