import java.util.*;

class Solution {
    public int mySqrt(int x) {
        // Time Complexity: O(LogN) to binary search on the answer.
        // Space Complexity: O(1) for a few variables.
        long l = 0;
        long r = x;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (m * m <= x && (m + 1) * (m + 1) > x) {
                return (int) m;
            }
            if (m * m < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return (int) l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter x: ");
        int x = sc.nextInt();
    
        System.out.println("Square root: ");
        System.out.println(new Solution().mySqrt(x));
    
        sc.close();
    }
}