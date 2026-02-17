import java.util.*;
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        // Time Complexity: O(N) because the strings have near identical sizes.
        //                  We use two pointers to traverse both strings simultaneously.
        // Space Complexity: O(1) for a few pointers.
        int sSize = s.length();
        int tSize = t.length();
        if (s.equals(t) || sSize > tSize + 1 || tSize > sSize + 1) {
            return false;
        }

        int sPointer = 0;
        int tPointer = 0;
        boolean used = false;
        boolean sameSize = sSize == tSize;
        while (sPointer < sSize && tPointer < tSize) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
                tPointer++;
                continue;
            }
            if (used) {
                return false;
            }
            if (sameSize) {
                sPointer++;
                tPointer++;
            } else {
                if (tSize > sSize) {
                    tPointer++;
                } else {
                    sPointer++;
                }
            }
            used = true;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        boolean result = solution.isOneEditDistance(s, t);

        System.out.println("Is one edit distance? " + result);

        sc.close();
    }
}