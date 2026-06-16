import java.util.*;
class Solution {
    public int maxPower(String s) {
        // Time Complexity: O(N) to loop over the string once.
        // Space Complexity: O(1) for a few variables.

        int maxPower = 1;
        int currPower = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currPower++;
                maxPower = Math.max(maxPower, currPower);
            } else {
                currPower = 1;
            }
        }

        return Math.max(maxPower, currPower);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
    
        Solution sol = new Solution();
        int result = sol.maxPower(s);
    
        System.out.println("Maximum power: ");
        System.out.println(result);
    
        sc.close();
    }
}