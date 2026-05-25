import java.util.*;
class Solution {
    int[] dp;

    public int maxJumps(int[] arr, int d) {
        // Time Complexity: O(N * D) because for each index, dfs takes at most 2 * D because of memoization.
        // Space Complexity: O(N) for dp array.
        dp = new int[arr.length];

        int answer = 1;

        for (int i = 0; i < arr.length; i++) {
            answer = Math.max(answer, search(i, arr, d));
        }

        return answer;
    }

    private int search(int currIdx, int[] arr, int d) {
        if (dp[currIdx] != 0) {
            return dp[currIdx];
        }
        int count = 1;

        // go left and then go right
        for (int i = currIdx - 1; i >= Math.max(0, currIdx - d); i--) {
            if (arr[i] >= arr[currIdx]) {
                break;
            }
            count = Math.max(count, 1 + search(i, arr, d));
        }
        for (int i = currIdx + 1; i <= Math.min(arr.length - 1, currIdx + d); i++) {
            if (arr[i] >= arr[currIdx]) {
                break;
            }
            count = Math.max(count, 1 + search(i, arr, d));
        }

        dp[currIdx] = count;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array: ");
        String line = sc.nextLine();
        String[] parts = line.split(" ");
        int[] arr = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
    
        System.out.println("Enter d: ");
        int d = sc.nextInt();
    
        Solution sol = new Solution();
        int result = sol.maxJumps(arr, d);
    
        System.out.println("Maximum jumps: ");
        System.out.println(result);
    
        sc.close();
    }
}