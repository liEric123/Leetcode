import java.util.*;
class Solution {
    public int reverseBits(int n) {
        // Time Complexity: O(1)
        // Space Complexity: O(1)
        int answer = 0;
        for (int i = 0; i <= 31; i++) {
            int bit = (n >> i) & 1;
            answer += bit << (31 - i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        Solution solution = new Solution();
        System.out.println("The result is: ");
        System.out.println(solution.reverseBits(n));
        sc.close();
    }
}