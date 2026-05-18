import java.util.*;
class Solution {
    public int[] concatWithReverse(int[] nums) {
        // Time Complexity: O(N) to build answer.
        // Space Complexity O(N) for answer.
        int[] concatAnswer = new int[nums.length * 2];
        
        for (int i = 0; i < nums.length; i++) {
            concatAnswer[i] = nums[i];
            concatAnswer[concatAnswer.length - 1 - i] = nums[i];
        }

        return concatAnswer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter nums: ");
        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Concatenated with reverse: ");
        System.out.println(Arrays.toString(new Solution().concatWithReverse(nums)));
    
        sc.close();
    }
}