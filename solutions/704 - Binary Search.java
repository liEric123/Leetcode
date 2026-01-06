import java.util.*;
class Solution {
    public int search(int[] nums, int target) {
        // Time Complexity: O(LogN) because the array is divided in half each time.
        // Space Complexity: O(1) for a few variables.
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.println("Enter the elements of the array: ");
        String input = scanner.nextLine().trim();

        int[] nums;
        if (input.isEmpty()) {
            nums = new int[0];
        } else {
            String[] inputArray = input.split(" ");
            nums = new int[inputArray.length];
            for (int i = 0; i < inputArray.length; i++) {
                nums[i] = Integer.parseInt(inputArray[i]);
            }
        }

        System.out.println("Enter the target value to search for: ");
        int target = scanner.nextInt();

        int result = solution.search(nums, target);

        if (result != -1) {
            System.out.println("Target " + target + " is found at index: " + result);
        } else {
            System.out.println("Target " + target + " is not found in the array.");
        }

        scanner.close();
    }
}