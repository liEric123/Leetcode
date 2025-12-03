import java.util.Scanner;
class Solution {
    public int reverse(int x) {
        // Time Complexity: O(log(|x|)) because that is how many digits are in x, and we loop over each digit.
        // Space Complexity: O(1) for some constants.
        int ans = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && digit == -9)) {
                return 0;
            }

            ans = ans * 10 + digit;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        System.out.println("Enter an integer to reverse:");
        int x = sc.nextInt();
        int result = sol.reverse(x);
        System.out.println("The reversed integer is: " + result);
    }
}