import java.util.*;
class Solution {
    public boolean validWordSquare(List<String> words) {
        // Time Complexity: O(N * M) to loop through all words.
        // Space Complexity: O(1) for in place checks.
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= words.size() || i >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter words (comma-separated): ");
        String[] parts = sc.nextLine().split(",");
    
        List<String> words = new ArrayList<>();
        for (String s : parts) {
            words.add(s.trim());
        }
    
        System.out.println("Valid word square: ");
        System.out.println(new Solution().validWordSquare(words));
    
        sc.close();
    }
}