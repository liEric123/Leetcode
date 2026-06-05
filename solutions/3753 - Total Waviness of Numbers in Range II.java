import java.util.*;
class Solution {
    // Stores the answer returned by a dp state.
    // Our dp state is (pos, status, prev2, prev1, tight).
    // Need to store both because if we find a wave (peak or valley), then all
    // integers that can be formed by the suffix inherit it.
    // Transition:
    // Curr totWaviness = Suffix totWaviness + validNums * isWave
    private class DPState {
        // How many full integers can be completed from this state.
        long validNums;
        // Sum of the waviness of all valid numbers of this state.
        long totWaviness;

        public DPState(long validNums, long totWaviness) {
            this.validNums = validNums;
            this.totWaviness = totWaviness;
        }
    }
    
    private DPState[][][][] memo; // non-tight memoization for suffix for a dp state.
    private static final int EMPTY = 10; // No previous digit yet.

    public long totalWaviness(long num1, long num2) {
        // Time Complexity: O(D) for # of digits in the upper bound number.
        //                  D * 3 * 11 * 11 unique states and each state has 10 digits to search for.
        // Space Complexity: O(D) for the dp table and call stack.

        // We can't just brute force this one since constraints are 10^15.
        // We will use Digit DP.

        // Leaves range [num1, num2]
        return count(num2) - count(num1 - 1);
    }

    private long count(long num) {
        // Convert to string for easy indexing.
        char[] digits = Long.toString(num).toCharArray();

        // memo[pos][status][prev2][prev1]
        // pos = curr index digit
        // status = number of prev digits that are valid
        // prev2 = digit value of prev prev
        // prev1 = digit value of prev
        // DON'T cache when tight is true because it happens only once anyways.
        memo = new DPState[digits.length][3][11][11];

        // We start tight and stay tight only if tight and next digit is max allowed.
        return dfs(0, 0, EMPTY, EMPTY, true, digits).totWaviness;
    }

    private DPState dfs(int pos, int status, int prev2, int prev1, boolean tight, char[] digits) {
        // Base case: If we get here we have finished a number. It contributes 1 valid number only.
        if (pos == digits.length) {
            return new DPState(1, 0);
        }

        // If we can reuse the already computed suffix results.
        // For example, 123_ and 223_.
        // Only check when tight isn't true because tight doesn't need caching.
        if (!tight && memo[pos][status][prev2][prev1] != null) {
            return memo[pos][status][prev2][prev1];
        }

        // What is the max digit we can build without potentially exceeding the upper range?
        int maxDigit = tight ? digits[pos] - '0' : 9;
        long currValidNums = 0;
        long currTotWaviness = 0;

        for (int i = 0; i <= maxDigit; i++) {
            int nextStatus;
            int nextPrev2;
            int nextPrev1;
            boolean isWave = false;

            if (status == 0 && i == 0) {
                // Case 1: Not yet found any valid digits.
                nextStatus = 0;
                nextPrev2 = EMPTY;
                nextPrev1 = EMPTY;
            } else if (status == 0 && i != 0) {
                // Case 2: Found first valid digit.
                nextStatus = 1;
                nextPrev2 = EMPTY;
                nextPrev1 = i;
            } else if (status == 1) {
                // Case 3: Found second valid digit.
                nextStatus = 2;
                nextPrev2 = prev1;
                nextPrev1 = i;
            } else {
                // Case 4: Can check if prev1 is peak or valley.
                if ((prev1 > prev2 && prev1 > i) || (prev1 < prev2 && prev1 < i)) {
                    isWave = true;
                }

                nextStatus = status;
                nextPrev2 = prev1;
                nextPrev1 = i;
            }
            boolean nextTight = tight && i == digits[pos] - '0';
            DPState suffixRes = dfs(pos + 1, nextStatus, nextPrev2, nextPrev1, nextTight, digits);

            currValidNums += suffixRes.validNums;
            int waveMultiplier = isWave ? 1 : 0;
            currTotWaviness += suffixRes.totWaviness + (suffixRes.validNums * waveMultiplier);
        }

        DPState currState = new DPState(currValidNums, currTotWaviness);
        // Save result only if not tight (restricted).
        if (!tight) {
            memo[pos][status][prev2][prev1] = currState;
        }

        return currState;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter num1: ");
        long num1 = Long.parseLong(sc.nextLine());
    
        System.out.println("Enter num2: ");
        long num2 = Long.parseLong(sc.nextLine());
    
        Solution sol = new Solution();
        long result = sol.totalWaviness(num1, num2);
    
        System.out.println("Total waviness: ");
        System.out.println(result);
    
        sc.close();
    }
}