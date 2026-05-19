import java.util.*;
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        // Time Complexity: O(N) to loop through the string.
        // Space Complexity: O(1) for a few variables.
        int blank = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L':
                    left++;
                    break;
                case 'R':
                    right++;
                    break;
                case '_':
                    blank++;
            }
        }

        if (left > right) {
            return left + blank - right;
        } else {
            return right + blank - left;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter moves: ");
        String moves = sc.nextLine();
    
        System.out.println("Furthest distance: ");
        System.out.println(new Solution().furthestDistanceFromOrigin(moves));
    
        sc.close();
    }
}