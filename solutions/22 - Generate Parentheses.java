import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
        // Time Complexity: O(Cn * n) since the Catalan number is the amount of valid parentheses.
        //                  For each string we have to build it which is O(N).
        // Space Complexity: O(Cn * n) for Cn strings of length 2n.
        List<String> answer = new ArrayList<>();
        dfs(n, answer, 0, 0, "");
        return answer;
    }

    void dfs(int n, List<String> answer, int open, int end, String curr) {
        if (open == n && end == n) {
            answer.add(curr);
            return;
        }
        if (open < n) {
            dfs(n, answer, open + 1, end, curr + "(");
        }
        if (end < n && open > end) {
            dfs(n, answer, open, end + 1, curr + ")");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        Solution sol = new Solution();
        List<String> result = sol.generateParenthesis(n);

        System.out.println("Generated parentheses: ");
        System.out.println(result);

        sc.close();
    }
}