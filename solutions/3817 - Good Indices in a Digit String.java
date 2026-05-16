import java.util.*;
class Solution {
    public List<Integer> goodIndices(String s) {
        // Time Complexity: O(N) to loop over each index of the string.
        // Space Complexity: O(N) to store the answers.
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            int currLen = String.valueOf(i).length();
            int substring = 0;

            for (int j = 0; j < currLen; j++) {
                substring += Math.pow(10, j) * (s.charAt(i - j) - '0');
            }

            if (substring == i) {
                answer.add(substring);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter s: ");
        String s = sc.nextLine();
    
        System.out.println("Good indices: ");
        System.out.println(new Solution().goodIndices(s));
    
        sc.close();
    }
}