import java.util.*;
class Solution {
    public int[] separateDigits(int[] nums) {
        // Time Complexity: O(N) to loop over the array to get answer array length.
        //                  And to loop over all the numbers to separate the digits.
        // Space Complexity: O(N) for the answer array.
        int answerArrSize = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            while (curr > 0) {
                curr /= 10;
                answerArrSize++;
            }
        }

        int[] answer = new int[answerArrSize];
        int ansIt = 0;
        for (int i = 0; i < nums.length; i++) {
            String curr = Integer.toString(nums[i]);
            for (int j = 0; j < curr.length(); j++) {
                answer[ansIt++] = curr.charAt(j) - '0';
            }
        }

        return answer;
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
        int[] result = sol.separateDigits(nums);
    
        System.out.println("Separated digits: ");
        System.out.println(Arrays.toString(result));
    
        sc.close();
    }
}