import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Time Complexity: O(N) to build hash set and loop through the array.
        // Space Complexity: O(N) for the hash set.
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements:");
        String line = sc.nextLine();

        String[] parts = line.trim().split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        Solution solution = new Solution();
        boolean result = solution.containsDuplicate(nums);

        System.out.println("Contains duplicate? " + (result ? "True" : "False"));

        sc.close();
    }
}