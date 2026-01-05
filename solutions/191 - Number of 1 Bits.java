import java.util.*;
class Solution {
    public int hammingWeight(int n) {
        // Time Complexity: O(1) because at most 32 set bits.
        // Space Complexity: O(1) for a few variables.
        int count = 0;
        while (n > 0) {
            n = n & n - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        Solution solution = new Solution();
        System.out.println("The result is: ");
        System.out.println(solution.hammingWeight(n));
        sc.close();
    }
}