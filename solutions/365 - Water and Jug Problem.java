import java.util.*;
class Solution {
    private Set<Long> visited = new HashSet<>();
    public boolean canMeasureWater(int x, int y, int target) {
        // Time Complexity: O(X * Y) if we visit each state, which can never be revisited.
        // Space Complexity: O(X * Y) for visited set.
        if (x + y < target) {
            return false;
        }
        return dfs(x, y, target, 0, 0);
    }

    private boolean dfs(int x, int y, int target, int currX, int currY) {
        if (currX + currY == target) {
            return true;
        }
        // encode the pair to long
        long key = ((long) currX << 32) | currY;
        if (visited.contains(key)) {
            return false;
        }
        visited.add(key);
        // 1. Fill X completely
        if (dfs(x, y, target, x, currY)) {
            return true;
        }
        // 2. Fill Y completely
        if (dfs(x, y, target, currX, y)) {
            return true;
        }
        // 3. Empty X completely
        if (dfs(x, y, target, 0, currY)) {
            return true;
        }
        // 4. Empty Y completely
        if (dfs(x, y, target, currX, 0)) {
            return true;
        }
        // 5. Transfer water from X to Y.
        //    Either we fill Y or we empty X, whichever comes first.
        int transferAmountXY = Math.min(currX, y - currY);
        if (dfs(x, y, target, currX - transferAmountXY, currY + transferAmountXY)) {
            return true;
        }
        // 6. Transfer water from Y to X.
        //    Either we fill X or we empty Y, whichever comes first.
        int transferAmountYX = Math.min(currY, x - currX);
        if (dfs(x, y, target, currX + transferAmountYX, currY - transferAmountYX)) {
            return true;
        }
        // None of the operations lead to success.
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter jug X capacity: ");
        int x = sc.nextInt();

        System.out.println("Enter jug Y capacity: ");
        int y = sc.nextInt();

        System.out.println("Enter target amount ");
        int target = sc.nextInt();

        Solution sol = new Solution();
        boolean result = sol.canMeasureWater(x, y, target);

        System.out.println("Can measure target: " + result);
        sc.close();
    }
}