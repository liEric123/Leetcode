import java.util.*;
class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        // Time Complexity: O(N) to build map of frequencies and scan each distinct value.
        // Space Complexity: O(N) for the HashMap.
        HashMap<Integer, Integer> map = new HashMap<>();
        int miniX = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
            miniX = Math.min(miniX, nums[i]);
        }
        int miniXFreq = map.get(miniX);

        int miniY = Integer.MAX_VALUE;
        for (int i : map.keySet()) {
            if (map.get(i) != miniXFreq && i > miniX && i < miniY) {
                miniY = i;
            }
        }
        
        if (miniY == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        return new int[]{miniX, miniY};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter nums: ");
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Minimum distinct frequency pair: ");
        System.out.println(Arrays.toString(new Solution().minDistinctFreqPair(nums)));
    
        sc.close();
    }
}