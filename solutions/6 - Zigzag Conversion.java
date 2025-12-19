import java.util.*;
class Solution {
    public String convert(String s, int numRows) {
        // Time Complexity: O(N) because we loop through every character, adding it to a row.
        // Space Complexity: O(N) because we store all characters.
        if (numRows == 1 || s.length() == 1) {
            return s;
        }
        List<List<Character>> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<Character>());
        }
        // -1 means going down, 1 mean going up.
        int direction = -1;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            rows.get(row).add(currChar);
            if (row == numRows - 1 && direction == -1) {
                direction *= -1;
                row--;
            } else if (row == 0 && direction == 1) {
                direction *= -1;
                row++;
            } else if (direction == -1) {
                row++;
            } else {
                row--;
            }
        }
        String answer = "";
        for (List<Character> i : rows) {
            for (char j : i) {
                answer += j;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to convert:");
        String s = sc.nextLine();
        System.out.println("Enter the number of rows:");
        int numRows = sc.nextInt();
        Solution sol = new Solution();
        String result = sol.convert(s, numRows);
        System.out.println("Converted ZigZag string:");
        System.out.println(result);
        sc.close();
    }
}