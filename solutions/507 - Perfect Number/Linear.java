import java.util.*;
class Solution {
    public boolean checkPerfectNumber(int num) {
        // Time Complexity: O(N) because we loop up to num checking for factors.
        // Space Complexity: O(1) for a few variables.
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        Solution sol = new Solution();
        System.out.println("Is perfect number?: " + sol.checkPerfectNumber(num));
        sc.close();
    }
}