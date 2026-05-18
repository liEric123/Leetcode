import java.util.*;
class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        // Time Complexity: O(NLogN) to sort the usage limits and the O(N) to scan over them.
        // Space Complexity: O(1) for a few variables and sorting.
        Collections.sort(usageLimits);

        int totGroups = 0;
        long capacity = 0;
        for (int i = 0; i < usageLimits.size(); i++) {
            capacity += usageLimits.get(i);
            long required = (totGroups + 1) * (totGroups + 2) / 2;

            if (capacity >= required) {
                totGroups++;
            }
        }

        return totGroups;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter usageLimits: ");
        List<Integer> usageLimits = new ArrayList<>();
        for (String s : sc.nextLine().split(" ")) {
            usageLimits.add(Integer.parseInt(s));
        }
    
        System.out.println("Maximum increasing groups: ");
        System.out.println(new Solution().maxIncreasingGroups(usageLimits));
    
        sc.close();
    }
}