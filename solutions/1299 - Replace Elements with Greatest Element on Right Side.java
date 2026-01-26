import java.util.*;
class Solution {
    public int[] replaceElements(int[] arr) {
        // Time Complexity: O(N) because we loop through the array once.
        // Space Complexity: O(1) for a few variables. We modify the array in place.
        int greatest = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int tempGreatest = greatest;
            if (arr[i] > greatest) {
                greatest = arr[i];
            }
            arr[i] = tempGreatest;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array: ");
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Solution sol = new Solution();
        System.out.println("Replaced array: " + Arrays.toString(sol.replaceElements(arr)));
        sc.close();
    }
}