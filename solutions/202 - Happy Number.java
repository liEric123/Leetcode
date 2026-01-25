import java.util.*;
class Solution {
    public boolean isHappy(int n) {
        // Time Complexity: O(LogN) because the number of digits in a number grows logarithmically.
        //                  So each operation to compute the sum of squares takes O(LogN) time.
        //                  The number of recursive calls is O(1) due to a small, finite cycle.
        // Space Complexity: O(1) because the set only stores a finite number of seen numbers.
        Set<Integer> seen = new HashSet<>();
        return dfs(n, seen);
    }

    public boolean dfs(int n, Set<Integer> seen) {
        if (n == 1) {
            return true;
        }
        if (seen.contains(n)) {
            return false;
        }
        seen.add(n);
        int sumOfSquares = 0;
        while (n > 0) {
            int digit = n % 10;
            sumOfSquares += digit * digit;
            n /= 10;
        }
        return dfs(sumOfSquares, seen);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        Solution sol = new Solution();
        System.out.println("Is the number happy?: " + sol.isHappy(n));
        sc.close();
    }
}