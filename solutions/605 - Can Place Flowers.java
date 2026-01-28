import java.util.*;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Time Complexity: O(N) to loop through the flowerbed.
        // Space Complexity: O(1) for a few variables.
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int left, right;
                if (i == 0) {
                    left = 0;
                } else {
                    left = flowerbed[i - 1];
                }
                if (i == flowerbed.length - 1) {
                    right = 0;
                } else {
                    right = flowerbed[i + 1];
                }
                if (left == 0 && right == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the flowerbed: ");
        int[] flowerbed = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Enter the number of flowers: ");
        int n = sc.nextInt();
        Solution sol = new Solution();
        System.out.println("Can place flowers?: " + sol.canPlaceFlowers(flowerbed, n));
        sc.close();
    }
}