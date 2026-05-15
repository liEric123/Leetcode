import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // Time Complexity: O(N) to slide the window through the string.
        // Space Complexity: O(N) for the set of all seen substrings and the answer.
        Set<String> seen = new HashSet<>();
        Set<String> answer = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String curr = s.substring(i, i + 10);
            if (seen.contains(curr)) {
                answer.add(curr);
            }
            seen.add(curr);
        }
        return new ArrayList<>(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter DNA string:");
        String s = sc.nextLine();
    
        Solution sol = new Solution();
        List<String> result = sol.findRepeatedDnaSequences(s);
    
        System.out.println("Repeated DNA sequences:");
        System.out.println(result);
    
        sc.close();
    }
}