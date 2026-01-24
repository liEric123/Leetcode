import java.util.*;
class Solution {
    public int[] getConcatenation(int[] nums) {
        // Time Complexity: O(N) to build the answer array.
        // Space Complexity: O(N) for answer array.
        int n = nums.length;
        int[] answer = new int[n * 2];
        for (int i = 0; i < n; i++) {
            answer[i] = answer[i + n] = nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String line = sc.nextLine();

        String[] parts = line.trim().split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        Solution solution = new Solution();
        int[] result = solution.getConcatenation(nums);

        System.out.print("Result: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        sc.close();
    }
}