import java.util.*;
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Time Complexity: O(L * NLogN + M + N) to sort the Strings since comparison can take O(L).
        //                  O(M + N) to build the answer because we use two pointers.
        // Space Complexity: O(N + M) for sorting the strings and for the answer list.
        List<List<String>> answer = new ArrayList<>();
        // Sort to allow for lexicographically minimal ordering.
        Arrays.sort(products);
        int left = 0;
        int right = products.length - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char searchChar = searchWord.charAt(i);

            // Remove invalid words.
            // Words are invalid if their length is less than the current search prefix length
            // or if the current character to search for doesn't match current String's character.
            while (left <= right &&
                   (products[left].length() <= i || products[left].charAt(i) != searchChar)) {
                left++;
            }
            while (left <= right &&
                   (products[right].length() <= i || products[right].charAt(i) != searchChar)) {
                right--;
            }

            List<String> currSuggestions = new ArrayList<>();
            int found = 0;
            while (left + found <= right && products[left + found].charAt(i) == searchChar &&
                   found < 3) {
                currSuggestions.add(products[left + found]);
                found++;
            }
            answer.add(currSuggestions);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter products: ");
        String[] products = sc.nextLine().split(" ");
    
        System.out.println("Enter search word: ");
        String searchWord = sc.nextLine();
    
        Solution sol = new Solution();
        List<List<String>> result = sol.suggestedProducts(products, searchWord);
    
        System.out.println("Suggested products: ");
        System.out.println(result);
    
        sc.close();
    }
}