import java.util.*;
class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        // Time Complexity: O(N) to loop over the digits of the string.
        // Space Complexity: O(1) for a few variables.
        for (int i = 0; i < s.length() - 1; i++) {
            int curr = s.charAt(i) - '0';
            int next = s.charAt(i + 1) - '0';
            
            if (curr - next > 2 || next - curr > 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter s: ");
        String s = sc.nextLine();
    
        System.out.println("Adjacent diff at most two: ");
        System.out.println(new Solution().isAdjacentDiffAtMostTwo(s));
    
        sc.close();
    }
}