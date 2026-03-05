import java.util.*;
class Solution {
    public boolean isTrionic(int[] nums) {
        // Time Complexity: O(N) to loop through the array checking the conditions.
        // Space Complexity: O(1) for a few variables.
        int n = nums.length;
        int i = 1;
        while (i < n) {
            if (nums[i] > nums[i - 1]) {
                i++;
            } else {
                break;
            }
        }
        if (i == 1 || i == n) {
            return false;
        }
        int p = i - 1;
        while (i < n) {
            if (nums[i] < nums[i - 1]) {
                i++;
            } else {
                break;
            }
        }
        if (i == n) {
            return false;
        }
        while (i < n) {
            if (nums[i] > nums[i - 1]) {
                i++;
            } else {
                break;
            }
        }
        if (i != n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array: ");
        String line = sc.nextLine().trim();
    
        String[] parts = line.split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        boolean result = sol.isTrionic(nums);
    
        System.out.println("Is trionic?: ");
        System.out.println(result);
    
        sc.close();
    }
}