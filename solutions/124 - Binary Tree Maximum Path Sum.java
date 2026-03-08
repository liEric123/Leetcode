import java.util.*;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // Time Complexity: O(N) because we visit each node once.
        // Space Complexity: O(H) for call stack. Worst case O(N) for skewed tree.
        dfs(root);
        return maxi;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        maxi = Math.max(maxi, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the tree: ");
        String line = sc.nextLine().trim();
    
        if (line.isEmpty()) {
            sc.close();
            return;
        }
    
        String[] parts = line.split("\\s+");
        TreeNode root = null;
    
        if (!parts[0].equals("null")) {
            root = new TreeNode(Integer.parseInt(parts[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
    
            int i = 1;
            while (!q.isEmpty() && i < parts.length) {
                TreeNode cur = q.poll();
    
                if (i < parts.length && !parts[i].equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(parts[i]));
                    q.offer(cur.left);
                }
                i++;
    
                if (i < parts.length && !parts[i].equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(parts[i]));
                    q.offer(cur.right);
                }
                i++;
            }
        }
    
        Solution sol = new Solution();
        int result = sol.maxPathSum(root);
    
        System.out.println("Maximum path sum: ");
        System.out.println(result);
        sc.close();
    }
}