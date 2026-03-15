import java.util.*;
class Solution {
    public int countPrimes(int n) {
        // Time Complexity: O(NLogLogN).
        // If we just crossed out multiples of each number, then it would be LogN.
        // However, we only cross out mutilples of prime numbers which allows the
        // time complexity to shrink to LogLogN.
        // Space Complexity: O(N) to track all number less than n.
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        int total = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter n: ");
        int n = Integer.parseInt(sc.nextLine());
    
        Solution sol = new Solution();
        int result = sol.countPrimes(n);
    
        System.out.println("Count of primes: ");
        System.out.println(result);
    
        sc.close();
    }
}