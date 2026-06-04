import java.util.*;
class Solution {
    public int totalWaviness(int num1, int num2) {
        // Time Complexity: O(N * D) to loop over all the numbers in the range and each digit.
        // Space Complexity: O(D) to represent each number as a string.
        int totAnswer = 0;
        for (int i = num1; i <= num2; i++) {
            String currNum = Integer.toString(i);

            if (currNum.length() < 3) {
                continue;
            }

            for (int j = 1; j < currNum.length() - 1; j++) {
                int currDigit = currNum.charAt(j);
                int prevDigit = currNum.charAt(j - 1);
                int nextDigit = currNum.charAt(j + 1);

                if ((currDigit > prevDigit && currDigit > nextDigit) ||
                    (currDigit < prevDigit && currDigit < nextDigit)) {
                    totAnswer++;
                }
            }
        }
        
        return totAnswer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter num1: ");
        int num1 = Integer.parseInt(sc.nextLine());
    
        System.out.println("Enter num2: ");
        int num2 = Integer.parseInt(sc.nextLine());
    
        Solution sol = new Solution();
        int result = sol.totalWaviness(num1, num2);
    
        System.out.println("Total waviness: ");
        System.out.println(result);
    
        sc.close();
    }
}