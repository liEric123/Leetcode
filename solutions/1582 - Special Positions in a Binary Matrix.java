import java.util.*;
class Solution {
    public int numSpecial(int[][] mat) {
        // Time Complexity: O(M * N) to loop through matrix twice.
        // Space Complexity: O(M + N) for the arrays of 1 counts.
        int m = mat.length;
        int n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter m and n: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
    
        int[][] mat = new int[m][n];
        System.out.println("Enter the matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    
        Solution sol = new Solution();
        int result = sol.numSpecial(mat);
    
        System.out.println("Number of special positions: ");
        System.out.println(result);
        sc.close();
    }
}