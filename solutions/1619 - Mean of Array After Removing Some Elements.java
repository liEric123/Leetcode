import java.util.*;
class Solution {
    public double trimMean(int[] arr) {
        // Time Complexity: O(N) to find the sum of the remaining elements.
        // Space Complexity: O(1) for a few variables and sorting.
        Arrays.sort(arr);
        double cutoff5 = arr.length * 0.05;
        
        double sum = 0.0;
        for (int i = (int) cutoff5; i < arr.length - (int) cutoff5; i++) {
            sum += arr[i];
        }

        return sum / (arr.length - 2 * cutoff5);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter arr: ");
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Trim mean: ");
        System.out.println(new Solution().trimMean(arr));
    
        sc.close();
    }
}