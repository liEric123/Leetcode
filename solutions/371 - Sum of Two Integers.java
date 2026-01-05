import java.util.*;
class Solution {
    public int getSum(int a, int b) {
        // Time Complexity: O(1) since carry moves 32 times at most.
        // Space Complexity: O(1) since recursion stack is at most 32 calls deep.
        if (b == 0) {
            return a;
        }
        return getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        Solution solution = new Solution();
        System.out.println("The sum is: " + solution.getSum(a, b));
        sc.close();
    }
}