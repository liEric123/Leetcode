import java.util.*;
class Solution {
    public int[] countBits(int n) {
        // Time Complexity: O(N) to build the array using dp.
        // Space Complexity: O(N) for the output array.
        int[] answer = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                answer[i] = answer[i / 2] + 1;
            } else {
                answer[i] = answer[i / 2];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Enter the number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution solution = new Solution();
        int[] result = solution.countBits(n);
        System.out.println("The result is: ");
        System.out.println(Arrays.toString(result));
        sc.close();
    }
}