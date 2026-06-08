import java.util.*;
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        // Time Complexity: O(N) to find numbers belong to each partition
        //                  and to create the answer list/array.
        //                  Can avoid autoboxing/unboxing by using array directly.
        // Space Complexity: O(N) for the partitioned lists and the answer array.
        List<Integer> lesser = new ArrayList<>();
        int equal = 0;
        List<Integer> greater = new ArrayList<>();

        for (int i : nums) {
            if (i < pivot) {
                lesser.add(i);
            } else if (i == pivot) {
                equal++;
            } else {
                greater.add(i);
            }
        }
        for (int i = 0; i < equal; i++) {
            lesser.add(pivot);
        }
        lesser.addAll(greater);

        int[] partitioned = new int[nums.length];
        for (int i = 0; i < lesser.size(); i++) {
            partitioned[i] = lesser.get(i);
        }
        return partitioned;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the array: ");
        String line = sc.nextLine();
    
        String[] parts = line.split(" ");
        int[] nums = new int[parts.length];
    
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
    
        System.out.println("Enter pivot: ");
        int pivot = Integer.parseInt(sc.nextLine());
    
        Solution sol = new Solution();
        int[] result = sol.pivotArray(nums, pivot);
    
        System.out.println("Partitioned array: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    
        sc.close();
    }
}