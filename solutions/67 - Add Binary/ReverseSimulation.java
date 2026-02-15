import java.util.*;
class Solution {
    public String addBinary(String a, String b) {
        // Time Complexity: O(max(M, N)) to loop over the strings' digits.
        // Space Complexity: O(max(M, N)) to store the answer.
        int carry = 0;
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (aIdx >= 0 || bIdx >= 0) {
            // Default to 0 if no digits left.
            int aCurr = 0;
            int bCurr = 0;
            if (aIdx >= 0) {
                aCurr = a.charAt(aIdx--) - '0';
            }
            if (bIdx >= 0) {
                bCurr = b.charAt(bIdx--) - '0';
            }
            int add = aCurr + bCurr + carry;
            switch (add) {
                case 0:
                    sb.append("0");
                    carry = 0;
                    break;
                case 1:
                    sb.append("1");
                    carry = 0;
                    break;
                case 2:
                    sb.append("0");
                    carry = 1;
                    break;
                case 3:
                    sb.append("1");
                    carry = 1;
                    break;
            }
        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.print("Enter first binary string: ");
        String a = sc.nextLine();

        System.out.print("Enter second binary string: ");
        String b = sc.nextLine();

        if (!a.matches("[01]+") || !b.matches("[01]+")) {
            System.out.println("Invalid input. Enter only binary numbers.");
            sc.close();
            return;
        }

        String result = solution.addBinary(a, b);
        System.out.println("Result: " + result);

        sc.close();
    }
}