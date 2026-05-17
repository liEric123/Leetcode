import java.util.*;
class Solution {
    public int dayOfYear(String date) {
        // Time Complexity: O(1) but can reduce some constant overhead.
        // Space Complexity: O(1) for a few constant variables.
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            daysOfMonth[1]++;
        }

        for (int i = 0; i < month - 1; i++) {
            day += daysOfMonth[i];
        }

        return day;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter date: ");
        String date = sc.nextLine();
    
        System.out.println("Day of year: ");
        System.out.println(new Solution().dayOfYear(date));
    
        sc.close();
    }
}