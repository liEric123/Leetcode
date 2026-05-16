import java.util.*;
class Solution {
    public boolean isGood(int[] nums) {
        // Time Complexity: O(N) to loop over the numbers once.
        // Space Complexity: O(N) to keep a frequency array.
        int n = nums.length - 1;
        int[] arr = new int[n];

        for (int i : nums) {
            if (i > n) {
                return false;
            }
            if (i == n && arr[i - 1] == 2) {
                return false;
            }
            if (i != n && arr[i - 1] == 1) {
                return false;
            }
            arr[i - 1]++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array: ");
        String[] parts = sc.nextLine().split(" ");
        int[] nums = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        boolean result = sol.isGood(nums);
    
        System.out.println("Is good array: ");
        System.out.println(result);
    
        sc.close();
    }
}