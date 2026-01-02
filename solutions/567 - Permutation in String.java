import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Time Complexity: O(N) to loop over s2 searching for s1 permutation.
        // Space Complexity: O(1) for fixed size frequency arrays.
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        for (int i = len1; i < len2; i++) {
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
            s2Count[s2.charAt(i) - 'a']++;
            s2Count[s2.charAt(i - len1) - 'a']--;
        }
        return Arrays.equals(s1Count, s2Count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter s1:");
        String s1 = sc.nextLine();
        System.out.println("Enter s2:");
        String s2 = sc.nextLine();
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion(s1, s2));
        sc.close();
    }
}