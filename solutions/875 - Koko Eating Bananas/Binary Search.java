import java.util.*;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Time Complexity: O(NLogM) where N is the number of piles and M is the largest pile.
        //                  We binary search in 1 to the largest pile for the smallest value of k.
        //                  Each iteration we loop over all piles to calculate the total hours.
        // Space Complexity: O(1) for a few variables.
        int largestPile = Integer.MIN_VALUE;
        for (int i : piles) {
            largestPile = Math.max(largestPile, i);
        }
        int answer = -1;
        int l = 1;
        int r = largestPile;
        while (l <= r) {
            // mid is k
            int mid = l + (r - l) / 2;
            // avoid overflow
            long hours = 0;
            for (int i : piles) {
                hours += (i + mid - 1) / mid;
            }
            if (hours <= h) {
                answer = mid;
                r = mid -1;
            } else {
                l = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the piles: ");
        String[] pileInput = sc.nextLine().trim().split("\\s+");
        int[] piles = new int[pileInput.length];

        for (int i = 0; i < pileInput.length; i++) {
            piles[i] = Integer.parseInt(pileInput[i]);
        }

        System.out.println("Enter the total hours (h): ");
        int h = sc.nextInt();

        Solution sol = new Solution();
        int result = sol.minEatingSpeed(piles, h);

        System.out.println("Minimum eating speed: " + result);
        sc.close();
    }
}