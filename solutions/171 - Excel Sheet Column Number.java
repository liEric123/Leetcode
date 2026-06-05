import java.util.*;
class Solution {
    public int titleToNumber(String columnTitle) {
        // Time Complexity: O(N) to loop over the title. No exponents needed.
        // Space Complexity: O(1) for a few variables.

        // Treat it like converting from binary or base-10 into a number.
        int answer = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            answer *= 26;
            answer += columnTitle.charAt(i) - 'A' + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter column title: ");
        String columnTitle = sc.nextLine();
    
        Solution sol = new Solution();
        int result = sol.titleToNumber(columnTitle);
    
        System.out.println("Column number: ");
        System.out.println(result);
    
        sc.close();
    }
}