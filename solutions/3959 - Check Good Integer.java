import java.util.*;
class Solution {
    public boolean checkGoodInteger(int n) {
        // Time Compleexity: O(LogN) to loop over each digit of the index.
        // Space Complexity: O(1) for a few variables.
        int digitSum = 0;
        int squareSum = 0;

        while (n > 0) {
            squareSum += (n % 10) * (n % 10);
            digitSum += n % 10;
            n /= 10;
        }

        return squareSum - digitSum >= 50;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter n: ");
        int n = sc.nextInt();
    
        Solution sol = new Solution();
        boolean result = sol.checkGoodInteger(n);
    
        System.out.println("Is good integer?: ");
        System.out.println(result);
    
        sc.close();
    }
}