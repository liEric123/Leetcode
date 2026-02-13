import java.util.*;
class Solution {
    public boolean isPowerOfTwo(int n) {
        // Time Complexity: O(1) because the bitwise operation doesn't depend on n.
        // Space Complexity: O(1) because no extra data structures used.
        return n > 0 && (n & n - 1) == 0;
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