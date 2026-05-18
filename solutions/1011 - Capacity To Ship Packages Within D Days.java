import java.util.*;
class Solution {
    private boolean canLoadDays(int capacity, int[] weights, int days) {
        int curr = 0;
        int totalDays = 1;
        
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity) {
                return false;
            }
            if (weights[i] + curr > capacity) {
                totalDays++;
                curr = 0;
            }
            curr += weights[i];
        }

        return totalDays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        // Time Complexity: O(NLogM) to binary search on the answer capacity.
        //                  Each helper check takes O(N) to loop over the weights.
        // Space Complexity: O(1) for a few variables.
        int l = 1;
        int r = Integer.MAX_VALUE;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (canLoadDays(m, weights, days)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter weights: ");
        int[] weights = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Enter days: ");
        int days = sc.nextInt();
    
        System.out.println("Minimum capacity: ");
        System.out.println(new Solution().shipWithinDays(weights, days));
    
        sc.close();
    }
}