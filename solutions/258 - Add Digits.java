import java.util.*;
class Solution {
    public int addDigits(int num) {
        // Time Complexity: O(LogN) to loop over the digits of num.
        // Space Complexity: O(1) for a few variables.
        while (num >= 10) {
            int temp = num;
            int newNum = 0;
            
            while (temp > 0) {
                newNum += temp % 10;
                temp /= 10;
            }
            
            num = newNum;
        }
        
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter num: ");
        int num = sc.nextInt();
    
        Solution sol = new Solution();
        int result = sol.addDigits(num);
    
        System.out.println("Added digits: ");
        System.out.println(result);
    
        sc.close();
    }
}