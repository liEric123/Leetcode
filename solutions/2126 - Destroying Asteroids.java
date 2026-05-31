import java.util.*;
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // Time Complexity: O(NLogN) to sort the asteroids.
        // Space Complexity: O(1) for sorting.
        Arrays.sort(asteroids);
        
        long massLong = mass;
        for (int i : asteroids) {
            if (i > massLong) {
                return false;
            }
            massLong += i;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter mass: ");
        int mass = Integer.parseInt(sc.nextLine());
    
        System.out.println("Enter asteroids: ");
        String line = sc.nextLine();
    
        String[] parts = line.split(" ");
        int[] asteroids = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            asteroids[i] = Integer.parseInt(parts[i]);
        }
    
        Solution sol = new Solution();
        boolean result = sol.asteroidsDestroyed(mass, asteroids);
    
        System.out.println("Can destroy all asteroids: ");
        System.out.println(result);
    
        sc.close();
    }
}