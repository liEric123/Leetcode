import java.util.*;
class Solution {
    public int findComplement(int num) {
        // Time Complexity: O(logN) to loop over the bits of N.
        // Space Complexity: O(1) for a few variables.
        int mask = 0;
        int copyN = num;
        while (num > 0) {
            mask = (mask << 1) + 1;
            num >>= 1;
        }
        return mask ^ copyN;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter n: ");
        int n = sc.nextInt();
    
        Solution sol = new Solution();
        int result = sol.findComplement(n);
    
        System.out.println("Bitwise complement: ");
        System.out.println(result);
    
        sc.close();
    }
}