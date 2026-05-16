import java.util.*;

class Solution {
    public int maximum69Number (int num) {
        // Time Complexity: O(N) to loop over each digit of the number.
        // Space Complexity: O(N) for the StringBuilder copy.
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '6') {
                sb.setCharAt(i, '9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter num: ");
        int num = sc.nextInt();
    
        System.out.println("Maximum 69 number: ");
        System.out.println(new Solution().maximum69Number(num));
    
        sc.close();
    }
}