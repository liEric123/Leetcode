import java.util.*;
class Solution {
    public boolean hasAlternatingBits(int n) {
        // Time Complexity: O(LogN) because we check each bit of the number. There are LogN bits.
        // Space Complexity: O(1) for a few variables.
        int bit = n % 2;
        n /= 2;
        while (n > 0) {
            if (n % 2 == bit) {
                return false;
            }
            bit = n % 2;
            n /= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter n: ");
        int n = sc.nextInt();
    
        Solution sol = new Solution();
        boolean result = sol.hasAlternatingBits(n);
    
        System.out.println("Has alternating bits?: ");
        System.out.println(result);
    
        sc.close();
    }
}