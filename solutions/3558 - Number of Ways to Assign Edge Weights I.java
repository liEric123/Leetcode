import java.util.*;
class Solution {
    public static final int MOD = 1000000007;

    public int assignEdgeWeights(int[][] edges) {
        // Time Complexity: O(N) to build the graph and DFS through the tree.
        //                  Also O(LogD) to binary exponentiate the depth.
        // Space Complexity: O(N) for adjacency list and DFS call stack.
        //                   Also O(LogD) for binary exponentiation call stack.
        List<Integer>[] graph = new ArrayList[edges.length + 2];
        for (int i = 1; i <= edges.length + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] i : edges) {
            int ui = i[0];
            int vi = i[1];
            graph[ui].add(vi);
            graph[vi].add(ui);
        }

        // Find deepest node.
        int maxDepth = dfs(1, 0, 0, graph);

        // Half of the total edge assignments have odd cost, and the other half have even cost.
        // So we divide total possibilities by 2 to get the answer.
        // Two choices for each edge weight so 2^(maxDepth - 1).
        return (int) exponentiate(2, maxDepth - 1);
    }

    private int dfs(int currNode, int parentNode, int currDepth, List<Integer>[] graph) {
        int currMax = currDepth;
        // Go into neighbors. We won't repeat nodes because it is a tree and we track parent node.
        for (int i : graph[currNode]) {
            if (parentNode == i) {
                continue;
            }
            currMax = Math.max(currMax, dfs(i, currNode, currDepth + 1, graph));
        }

        return currMax;
    }

    private long exponentiate(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        long temp = exponentiate(base, exponent / 2);
        long answer = (temp * temp) % MOD;
        if (exponent % 2 == 1) {
            answer = answer * base % MOD;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter edges, empty line to stop: ");
        ArrayList<int[]> list = new ArrayList<>();
    
        while (true) {
            String line = sc.nextLine().trim();
    
            if (line.isEmpty()) {
                break;
            }
    
            String[] parts = line.split(" ");
            list.add(new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])});
        }
    
        int[][] edges = new int[list.size()][2];
    
        for (int i = 0; i < list.size(); i++) {
            edges[i] = list.get(i);
        }
    
        Solution sol = new Solution();
        int result = sol.assignEdgeWeights(edges);
    
        System.out.println("Number of valid assignments: ");
        System.out.println(result);
    
        sc.close();
    }
}