import java.util.*;
class Solution {
    public int passwordStrength(String password) {
        // Time Complexity: O(N) to loop over the password, calculating the strength.
        // Space Complexity: O(N) for a set of seen characters.
        Set<Character> seen = new HashSet<>();
        int strength = 0;
        for (int i = 0; i < password.length(); i++) {
            char curr = password.charAt(i);
            if (seen.contains(curr)) {
                continue;
            }
            
            if (curr >= 'a' && curr <= 'z') {
                strength += 1;
            } else if (curr >= 'A' && curr <= 'Z') {
                strength += 2;
            } else if (curr >= '0' && curr <= '9') {
                strength += 3;
            } else {
                strength += 5;
            }
            seen.add(curr);
        }

        return strength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the password: ");
        String password = sc.nextLine();
    
        Solution sol = new Solution();
        int result = sol.passwordStrength(password);
    
        System.out.println("Password strength: ");
        System.out.println(result);
    
        sc.close();
    }
}