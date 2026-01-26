import java.util.*;
class Solution {
    public boolean checkPerfectNumber(int num) {
        // Time Complexity: O(Sqrt(N)) because we only need to loop up to the square root of num.
        //                  This way we can find both corresponding factors at once.
        // Space Complexity: O(1) for a few variables.
        int sum = 1;
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i + num / i;
                if (i * i == num) {
                    sum -= i;
                }
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