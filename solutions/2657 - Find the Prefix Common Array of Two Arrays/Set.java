import java.util.*;
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // Time Complexity: O(N) to loop over the arrays.
        // Space Complexity: O(N) for set and answer array.
        Set<Integer> seen = new HashSet<>();
        int[] answer = new int[A.length];
        int seenTotal = 0;
        for (int i = 0; i < A.length; i++) {
            if (seen.contains(A[i])) {
                seenTotal++;
            }
            seen.add(A[i]);
            if (seen.contains(B[i])) {
                seenTotal++;
            }
            seen.add(B[i]);
            answer[i] = seenTotal;
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