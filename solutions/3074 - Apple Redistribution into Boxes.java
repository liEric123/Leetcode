import java.util.*;
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        // Time Complexity: O(N + MLogM) to sort the capacities and greedily assign apple boxes.
        // Space Complexity: O(1) for a few variables + sorting.
        Arrays.sort(capacity);
        int sum = 0;
        int boxesNeeded = 0;
        for (int i : apple) {
            sum += i;
        }
        for (int i = capacity.length - 1; i >= 0; i--) {
            int currCap = capacity[i];
            if (sum > 0) {
                sum -= currCap;
            } else {
                return boxesNeeded;
            }
            boxesNeeded++;
        }
        return boxesNeeded;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter apple: ");
        int[] apple = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Enter capacity: ");
        int[] capacity = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    
        System.out.println("Minimum boxes needed: ");
        System.out.println(new Solution().minimumBoxes(apple, capacity));
    
        sc.close();
    }
}