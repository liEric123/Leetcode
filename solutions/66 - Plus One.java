import java.util.*;
class Solution {
    public int[] plusOne(int[] digits) {
        // Time Complexity: O(N) to loop through all digits worst case.
        // Space Complexity: O(N) worst case if all digits are 9 we must create new array.
        int size = digits.length;
        if (digits[size - 1] != 9) {
            digits[size - 1]++;
            return digits;
        }
        for (int i = size - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] answer = new int[size + 1];
        answer[0] = 1;
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the digits array: ");
        String line = sc.nextLine().trim();
    
        if (line.isEmpty()) {
            System.out.println("Result: ");
            System.out.println();
            sc.close();
            return;
        }
    
        int[] digits;
    
        if (line.contains(" ")) {
            String[] parts = line.split("\\s+");
            digits = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                digits[i] = Integer.parseInt(parts[i]);
            }
        } else {
            digits = new int[line.length()];
            for (int i = 0; i < line.length(); i++) {
                digits[i] = line.charAt(i) - '0';
            }
        }
    
        Solution sol = new Solution();
        int[] result = sol.plusOne(digits);
    
        System.out.println("Result: ");
        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(result[i]);
        }
        System.out.println();
    
        sc.close();
    }
}