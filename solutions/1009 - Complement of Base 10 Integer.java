import java.util.*;
class Solution {
    public int bitwiseComplement(int n) {
        // Time Complexity: O(logN) to loop over the bits of N.
        // Space Complexity: O(1) for a few variables.
        if (n == 0) {
            return 1;
        }
        int copyN = n;
        int mask = 0;
        while (n > 0) {
            mask = (mask << 1) | 1;
            n = n >> 1;
        }
        return mask ^ copyN;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter n: ");
        int n = sc.nextInt();
    
        Solution sol = new Solution();
        int result = sol.bitwiseComplement(n);
    
        System.out.println("Bitwise complement: ");
        System.out.println(result);
    
        sc.close();
    }
}