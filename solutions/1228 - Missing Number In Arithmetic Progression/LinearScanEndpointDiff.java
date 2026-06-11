import java.util.*;
class Solution {
    public int missingNumber(int[] arr) {
        // Time Complexity: O(N) to loop through the arr, checking for the missing number.
        // Space Complexity: O(1) for a few variables.
        // Given that the first and last values are valid, find common difference.
        int d = (arr[arr.length - 1] - arr[0]) / arr.length;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + d != arr[i]) {
                return arr[i - 1] + d;
            }
        }

        // Handles case where difference is 0.
        return arr[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array: ");
        String line = sc.nextLine();
    
        String[] parts = line.split(" ");
        int[] arr = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        int result = sol.missingNumber(arr);
    
        System.out.println("Missing number: ");
        System.out.println(result);
    
        sc.close();
    }
}