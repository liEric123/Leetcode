import java.util.*;
class Solution {
    public int countPrimeSetBits(int left, int right) {
        // Time Complexity: O(N) to loop from right to left.
        //                  Counting set bits for each number is fixed constant.
        //                  Determing isPrime for a small int is fixed constant.
        // Space Complexity: O(1) for a few variables.
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(countSetBits(i))) {
                count++;
            }
        }
        return count;
    }

    private int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter left and right:");
        int left = sc.nextInt();
        int right = sc.nextInt();

        Solution sol = new Solution();
        int result = sol.countPrimeSetBits(left, right);

        System.out.println("Count of numbers with prime set bits:");
        System.out.println(result);

        sc.close();
    }
}