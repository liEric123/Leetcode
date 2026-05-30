import java.util.*;
class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        // Time Complexity: O(N) to loop through the mountains.
        // Space Complexity: O(N) for the answer list.
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                answer.add(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the heights: ");
        String line = sc.nextLine();
    
        String[] parts = line.split(" ");
        int[] height = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            height[i] = Integer.parseInt(parts[i]);
        }
    
        System.out.println("Enter threshold: ");
        int threshold = sc.nextInt();
    
        Solution sol = new Solution();
        List<Integer> result = sol.stableMountains(height, threshold);
    
        System.out.println("Stable mountain indices: ");
        System.out.println(result);
    
        sc.close();
    }
}