import java.util.*;
class Solution {
    public int binaryGap(int n) {
        // Time Complexity: O(Log(N)) because there are that many bits in N.
        //                  Also N is divided by two each time.
        // Space Complexity: O(1) for a few variables.
        int longestGap = 0;
        while (n > 0 && n % 2 == 0) {
            n /= 2;
        }
        int currGap = 0;
        while (n > 0) {
            int currBit = n % 2;
            if (currBit == 0) {
                currGap++;
            } else {
                longestGap = Math.max(longestGap, currGap);
                currGap = 1;
            }
            n /= 2;
        }
        return longestGap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = sc.nextInt();

        Solution sol = new Solution();
        int ans = sol.binaryGap(n);

        System.out.println("Binary gap: ");
        System.out.println(ans);

        sc.close();
    }
}