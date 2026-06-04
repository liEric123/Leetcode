import java.util.*;
class Solution {
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u',
                                                        'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        // Time Complexity: O(N) to move two pointers through the string. Set operations are O(1).
        //                  Can use an char array for more optimal performance.
        // Space Complexity: O(N) for the StringBuilder. Set of vowels is constant.
        StringBuilder sb = new StringBuilder(s);
        int l = 0;
        int r = s.length() - 1;
        char lChar = sb.charAt(l);
        char rChar = sb.charAt(r);
        while (l < r) {
            lChar = sb.charAt(l);
            rChar = sb.charAt(r);
            if (vowels.contains(lChar) && vowels.contains(rChar)) {
                char temp = lChar;
                sb.setCharAt(l, rChar);
                sb.setCharAt(r, temp);
                l++;
                r--;
            } else if (!vowels.contains(lChar)) {
                l++;
            } else if (!vowels.contains(rChar)) {
                r--;
            } else {
                l++;
                r--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
    
        Solution sol = new Solution();
        String result = sol.reverseVowels(s);
    
        System.out.println("String after reversing vowels: ");
        System.out.println(result);
    
        sc.close();
    }
}