import java.util.*;
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // Time Complexity: O((N + M) * Log k) to first add all prefixes of arr1,
        //                  and then check all integers in arr2.
        //                  For each int, we need to extract each digit.
        // Space Complexity: O(N) to store all of the prefixes of arr1.
        //                   Storing prefixes requires more space than just storing integers.
        Set<Integer> prefix = new HashSet<>();
        for (int i : arr1) {
            while (i > 0) {
                prefix.add(i);
                i /= 10;
            }
        }
        
        int longestPrefix = 0;
        for (int i : arr2) {
            while (i > 0) {
                if (prefix.contains(i) && String.valueOf(i).length() > longestPrefix) {
                    longestPrefix = String.valueOf(i).length();
                    break;
                }
                i /= 10;
            }
        }

        return longestPrefix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter arr1: ");
        String line1 = sc.nextLine();
    
        System.out.println("Enter arr2: ");
        String line2 = sc.nextLine();
    
        String[] parts1 = line1.split(" ");
        String[] parts2 = line2.split(" ");
    
        int[] arr1 = new int[parts1.length];
        int[] arr2 = new int[parts2.length];
    
        for (int i = 0; i < parts1.length; i++) {
            arr1[i] = Integer.parseInt(parts1[i]);
        }
    
        for (int i = 0; i < parts2.length; i++) {
            arr2[i] = Integer.parseInt(parts2[i]);
        }
    
        Solution sol = new Solution();
        int result = sol.longestCommonPrefix(arr1, arr2);
    
        System.out.println("Longest common prefix length: ");
        System.out.println(result);
    
        sc.close();
    }
}