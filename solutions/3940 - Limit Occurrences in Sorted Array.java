import java.util.*;
class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        // Time Complexity: O(N) to loop over nums to build the answer list.
        //                  Also, then to convert list to array.
        // Space Complexity: O(N) for the limited list and array.
        int currOccur = 1;
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                currOccur++;
            } else {
                currOccur = 1;
            }

            if (currOccur <= k) {
                answer.add(nums[i]);
            }
        }
        
        int[] answerArr = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            answerArr[i] = answer.get(i);
        }

        return answerArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array: ");
        String line = sc.nextLine();
    
        System.out.println("Enter k: ");
        int k = sc.nextInt();
    
        String[] parts = line.split(" ");
        int[] nums = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int[] result = sol.limitOccurrences(nums, k);
    
        System.out.println("Limited array: ");
        System.out.println(Arrays.toString(result));
    
        sc.close();
    }
}