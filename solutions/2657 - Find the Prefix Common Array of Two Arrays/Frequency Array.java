import java.util.*;
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // Time Complexity: O(N) to loop over the arrays.
        // Space Complexity: O(N) for frequency and answer arrays.
        int counter = 0;
        int n = A.length;
        int[] frequencies = new int[n + 1];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            frequencies[A[i]]++;
            if (frequencies[A[i]] == 2) {
                counter++;
            }
            frequencies[B[i]]++;
            if (frequencies[B[i]] == 2) {
                counter++;
            }

            answer[i] = counter;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter A: ");
        int[] A = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Enter B: ");
        int[] B = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Prefix common array: ");
        System.out.println(Arrays.toString(new Solution().findThePrefixCommonArray(A, B)));
    
        sc.close();
    }
}