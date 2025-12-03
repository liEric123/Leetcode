import java.util.Scanner;
class Solution {
    public int removeElement(int[] nums, int val) {
        // Time Complexity: O(N) because we go through each element from left to right.
        // Space Complexity: O(1) because it is in-place.
        int moveTo = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val)
            {
                continue;
            }
            else
            {
                nums[moveTo] = nums[i];
                moveTo++;
            }
        }
        return moveTo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input numbers separated by spaces:");
        String[] parts = sc.nextLine().split(" ");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) nums[i] = Integer.parseInt(parts[i]);
        System.out.println("Input value to remove:");
        int val = sc.nextInt();

        Solution s = new Solution();
        int k = s.removeElement(nums, val);

        System.out.println("New length: " + k);
        System.out.print("Array after removal: ");
        for (int i = 0; i < k; i++) System.out.print(nums[i] + " ");
    }
}