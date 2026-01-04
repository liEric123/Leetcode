
import java.util.*;
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Time Complexity: O(NLogN) to sort the array by position. O(N) to loop through cars.
        // Space Complexity: O(N) for array of both position and speed and stack.
        int[][] car = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }
        // sort by position descending
        Arrays.sort(car, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < car.length; i++) {
            double time = (double) (target - car[i][0]) / car[i][1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter target:");
        int target = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter positions:");
        String[] posParts = sc.nextLine().trim().split("\\s+");
        int[] position = new int[posParts.length];
        for (int i = 0; i < posParts.length; i++) {
            position[i] = Integer.parseInt(posParts[i]);
        }

        System.out.println("Enter speeds:");
        String[] speedParts = sc.nextLine().trim().split("\\s+");
        int[] speed = new int[speedParts.length];
        for (int i = 0; i < speedParts.length; i++) {
            speed[i] = Integer.parseInt(speedParts[i]);
        }

        Solution sol = new Solution();
        int result = sol.carFleet(target, position, speed);

        System.out.println("Number of car fleets: " + result);
        sc.close();
    }
}