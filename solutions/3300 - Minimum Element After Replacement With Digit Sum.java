import java.util.*;
class Solution {
    public int minElement(int[] nums) {
        // Time Complexity: O(N * LogK) to loop over the array once.
        //                  For each number, we sum its digits which is Log time.
        // Space Complexity: O(1) for a few variables.
        int mini = Integer.MAX_VALUE;

        for (int i : nums) {
            int digitSum = 0;
            while (i > 0) {
                digitSum += i % 10;
                i /= 10;
            }

            mini = Math.min(mini, digitSum);
        }

        return mini;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array: ");
        String line = sc.nextLine();
    
        String[] parts = line.split(" ");
        int[] nums = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int result = sol.minElement(nums);
    
        System.out.println("Minimum digit sum: ");
        System.out.println(result);
    
        sc.close();
    }
}