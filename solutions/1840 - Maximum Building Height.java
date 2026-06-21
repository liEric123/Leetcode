import java.util.*;
class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        // Time Complexity: O(RLogR) to sort the restrictions array. Everything else is O(N).
        // Space Complexity: O(R) to sort and store the new restrictions array.
        
        // Simulating each building height isn't possible given constraints.
        // Restrictions aren't ordered initially, so sort them by index.
        List<int[]> restrictionList = new ArrayList<>();
        for (int[] res : restrictions) {
            restrictionList.add(res);
        }
        
        restrictionList.add(new int[]{1, 0});
        restrictionList.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        if (restrictionList.get(restrictionList.size() - 1)[0] != n) {
            restrictionList.add(new int[]{n, n - 1});
        }

        int r = restrictionList.size();
        // L to R pass through each restricted building.
        // A building is limited by its left neighbor.
        for (int i = 1; i < r; i++) {
            int spaceBetween = restrictionList.get(i)[0] - restrictionList.get(i - 1)[0];
            restrictionList.get(i)[1] = Math.min(restrictionList.get(i)[1],
                                                 restrictionList.get(i - 1)[1] + spaceBetween);
        }

        // R to L pass through each restricted building.
        // A building is also limited by its right neighbor.
        for (int i = r - 2; i >= 0; i--) {
            int spaceBetween = restrictionList.get(i + 1)[0] - restrictionList.get(i)[0];
            restrictionList.get(i)[1] = Math.min(restrictionList.get(i)[1],
                                                 restrictionList.get(i + 1)[1] + spaceBetween);
        }

        // One more pass to find peak between two boundaries.
        // Max height = ((r - l) + height_l + height_r) / 2
        // (Can be derived by thinking about how many free steps you have between two boundaries).
        int maxHeight = 0;
        for (int i = 0; i < r - 1; i++) {
            int[] left = restrictionList.get(i);
            int[] right = restrictionList.get(i + 1);
                        
            int peak = ((right[0] - left[0]) + left[1] + right[1]) / 2;
            maxHeight = Math.max(maxHeight, peak);
        }

        return maxHeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter n: ");
        int n = Integer.parseInt(sc.nextLine());
    
        System.out.println("Enter restrictions, empty line to stop: ");
        List<int[]> list = new ArrayList<>();
    
        while (true) {
            String line = sc.nextLine().trim();
    
            if (line.length() == 0) {
                break;
            }
    
            String[] parts = line.split(" ");
            list.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
        }
    
        int[][] restrictions = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            restrictions[i] = list.get(i);
        }
    
        Solution sol = new Solution();
        int result = sol.maxBuilding(n, restrictions);
    
        System.out.println("Maximum building height: ");
        System.out.println(result);
    
        sc.close();
    }
}