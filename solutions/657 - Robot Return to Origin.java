import java.util.*;
class Solution {
    public boolean judgeCircle(String moves) {
        // Time Complexity: O(N) to loop over the string.
        // Space Complexity: O(1) for a few variables.
        int vertical = 0;
        int horizontal = 0;

        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'R':
                    horizontal++;
                    break;
                case 'L':
                    horizontal--;
                    break;
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
            }
        }

        return vertical == 0 && horizontal == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter moves: ");
        String moves = sc.nextLine();
    
        System.out.println("Returns to origin: ");
        System.out.println(new Solution().judgeCircle(moves));
    
        sc.close();
    }
}