import java.util.*;
class Solution {
    public double angleClock(int hour, int minutes) {
        // Time Complexity: O(1) for math formula.
        // Space Complexity: O(1) for a few variables.
        if (hour == 12) {
            hour = 0;
        }
        // Hour depends on minutes as well.
        double hourAngle = ((hour / 12.0) * 360) + ((minutes / (60.0 * 12)) * 360);
        double minuteAngle = (minutes / 60.0) * 360;

        double angle = Math.abs(minuteAngle - hourAngle);
        return Math.min(angle, 360 - angle);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter hour: ");
        int hour = sc.nextInt();
    
        System.out.println("Enter minutes: ");
        int minutes = sc.nextInt();
    
        Solution sol = new Solution();
        double result = sol.angleClock(hour, minutes);
    
        System.out.println("Angle: ");
        System.out.printf("%.5f\n", result);
    
        sc.close();
    }
}