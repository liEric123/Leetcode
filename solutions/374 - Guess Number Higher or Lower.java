import java.util.*;

class GuessGame {
    static int picked;

    public int guess(int num) {
        if (num > picked) return -1;
        if (num < picked) return 1;
        return 0;
    }
}

class Solution extends GuessGame {

    private int guessHelper(int min, int max) {
        // Time Complexity: O(LogN) for binary search.
        // Space Complexity: O(LogN) for recursion stack.
        int mid = min + (max - min) / 2;
        if (guess(mid) == -1) {
            return guessHelper(min, mid - 1);
        } else if (guess(mid) == 1) {
            return guessHelper(mid + 1, max);
        } else {
            return mid;
        }
    }

    public int guessNumber(int n) {
        return guessHelper(1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Enter picked number: ");
        GuessGame.picked = sc.nextInt();

        Solution sol = new Solution();
        int result = sol.guessNumber(n);

        System.out.println("Guessed number: ");
        System.out.println(result);

        sc.close();
    }
}