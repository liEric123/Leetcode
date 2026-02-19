import java.util.*;
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        // Time Complexity: O(N) for simple simulation for each index.
        // Space Complexity: O(N) for the answer array.
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int targetIdx;
            if (nums[i] > 0) {
                targetIdx = (i + nums[i]) % n;
            } else if (nums[i] < 0) {
                targetIdx = (i - Math.abs(nums[i])) % n;
                if (targetIdx < 0) {
                    targetIdx += n;
                }
            } else {
                targetIdx = i;
            }
            result[i] = nums[targetIdx];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array:");
        String line = sc.nextLine().trim();
    
        if (line.isEmpty()) {
            System.out.println("Transformed array:");
            System.out.println("[]");
            sc.close();
            return;
        }
    
        String[] parts = line.split("\\s+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int[] ans = sol.constructTransformedArray(nums);
    
        System.out.println("Transformed array:");
        System.out.print("[");
        for (int i = 0; i < ans.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(ans[i]);
        }
        System.out.println("]");
    
        sc.close();
    }    
}