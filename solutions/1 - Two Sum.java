import java.util.HashMap;
import java.util.Scanner;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                answer[0] = map.get(target - nums[i]);
                answer[1] = i;
                return answer;
            }
            map.put(nums[i], i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.println("Enter the numbers in the array:");
        String input = sc.nextLine();
        String[] numbers = input.split(" ");
        int[] nums = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println("Enter the target sum:");
        int target = sc.nextInt();
        int[] result = sol.twoSum(nums, target);
        System.out.println("The two numbers that add up to the target are indices: " + result[0] + " and " + result[1]);
    }
}