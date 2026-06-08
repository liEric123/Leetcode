import java.util.*;
class Solution {
    public int xorOperation(int n, int start) {
        // Time Complexity: O(N) to simulate all N XOR operations.
        // Space Complexity: O(1) for a few variables.
        int xor = start;
        for (int i = 1; i < n; i++) {
            xor ^= (start + 2 * i);
        }

        return xor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter n: ");
        int n = Integer.parseInt(sc.nextLine());
    
        System.out.println("Enter start: ");
        int start = Integer.parseInt(sc.nextLine());
    
        Solution sol = new Solution();
        int result = sol.xorOperation(n, start);
    
        System.out.println("XOR result: ");
        System.out.println(result);
    
        sc.close();
    }
}