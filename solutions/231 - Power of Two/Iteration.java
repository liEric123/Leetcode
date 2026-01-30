import java.util.*;

class Solution {
    public boolean isPowerOfTwo(int n) {
        // Time Complexity: O(LogN) to build the powers of 2.
        //                  Each iteration doubles curr.
        // Space Complexity: O(1) for a few variables.
        long curr = 1;
        while (n >= curr) {
            if (n == curr) {
                return true;
            }
            
            curr *= 2;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
    
        Solution sol = new Solution();
        boolean result = sol.isPowerOfTwo(n);
    
        if (result) {
            System.out.println(n + " is a power of two.");
        } else {
            System.out.println(n + " is not a power of two.");
        }
    
        sc.close();
    }
}