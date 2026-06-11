import java.util.*;
class Solution {
    public int missingNumber(int[] arr) {
        // Time Complexity: O(N) to loop through the arr, checking for the missing number.
        // Space Complexity: O(1) for a few variables.
        int diff1 = arr[1] - arr[0];
        int diff2 = arr[2] - arr[1];
        // If we have 1st, 3rd, 4th, adding the diff between 3rd and 4th to 1st gives us 2nd.
        // If we have 1st, 2nd, 4th, adding the diff between 2nd and 4th to 1st gives us 3rd.
        if (diff2 != diff1) {
            return arr[0] + diff2;
        }

        // Check for expected number in the progression.
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + diff1 != arr[i + 1]) {
                return arr[i] + diff1;
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