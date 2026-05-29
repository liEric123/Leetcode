import java.util.*;
class Solution {
    public int getLucky(String s, int k) {
        // Time Complexity: O(N + K * LogN) to convert s into int and sum digits of converted string.
        //                  Then O(K) to repeat transform operations.
        // Space Complexity: O(N) for the StringBuilder.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(1 + s.charAt(i) - 'a');
        }

        int sum = 0;
        for (char c : sb.toString().toCharArray()) {
            sum += c - '0';
        }
        k--;

        while (k > 0) {
            int temp = 0;
            while (sum > 0) {
                temp += sum % 10;
                sum /= 10;
            }

            sum = temp;
            k--;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
    
        System.out.println("Enter k: ");
        int k = sc.nextInt();
    
        Solution sol = new Solution();
        int result = sol.getLucky(s, k);
    
        System.out.println("Lucky value: ");
        System.out.println(result);
    
        sc.close();
    }
}