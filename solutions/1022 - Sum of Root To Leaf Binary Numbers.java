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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        // Time Complexity: O(N) because we visit each node once.
        // Space Complexity: O(H) for call stack. Worst case O(N) for a skewed tree.
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int curr) {
        if (root == null) {
            return;
        }
        curr = curr << 1 | root.val;
        if (root.left == null && root.right == null) {
            sum += curr;
        }
        dfs(root.left, curr);
        dfs(root.right, curr);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the tree: ");
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println("Sum of root-to-leaf: ");
            System.out.println(0);
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
                TreeNode node = q.poll();
    
                if (i < parts.length && !parts[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(parts[i]));
                    q.offer(node.left);
                }
                i++;
    
                if (i < parts.length && !parts[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(parts[i]));
                    q.offer(node.right);
                }
                i++;
            }
        }
    
        Solution sol = new Solution();
        int result = sol.sumRootToLeaf(root);
    
        System.out.println("Sum of root-to-leaf: ");
        System.out.println(result);
        sc.close();
    }
}