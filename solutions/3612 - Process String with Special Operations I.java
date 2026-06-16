import java.util.*;
class Solution {
    public String processStr(String s) {
        // Time Complexity: O(2^N) worst case for duplicating list every single time.
        // Space Complexity: O(2^N) to store the worst case exponential answer.
        List<Character> answer = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                answer.add(c);
            } else if (c == '*') {
                if (!answer.isEmpty()) {
                    answer.remove(answer.size() - 1);
                }
            } else if (c == '#') {
                answer.addAll(new ArrayList<>(answer));
            } else {
                Collections.reverse(answer);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : answer) {
            sb.append(c);
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter string: ");
        String s = sc.nextLine();
    
        Solution sol = new Solution();
        String result = sol.processStr(s);
    
        System.out.println("Processed string: ");
        System.out.println(result);
    
        sc.close();
    }
}