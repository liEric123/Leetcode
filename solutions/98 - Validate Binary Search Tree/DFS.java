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
    public boolean isValidBST(TreeNode root) {
        // Time Complexity: O(N) because we visit each node in the BST.
        // Space Complexity: O(H) for the recursion stack. O(N) worst case for a skewed tree.
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, int lower, int higher) {
        if (root == null) {
            return true;
        }
        // Check curr node with global bounds.
        if (root.val <= lower || root.val >= higher) {
            return false;
        }
        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, higher);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter BST values: ");
        String line = sc.nextLine().trim();

        TreeNode root = null;

        if (!line.isEmpty()) {
            String[] tokens = line.split("\\s+");

            if (!tokens[0].equalsIgnoreCase("null")) {
                root = new TreeNode(Integer.parseInt(tokens[0]));
                Queue<TreeNode> q = new ArrayDeque<>();
                q.add(root);

                int i = 1;
                while (!q.isEmpty() && i < tokens.length) {
                    TreeNode cur = q.poll();

                    if (i < tokens.length && !tokens[i].equalsIgnoreCase("null")) {
                        cur.left = new TreeNode(Integer.parseInt(tokens[i]));
                        q.add(cur.left);
                    }
                    i++;

                    if (i < tokens.length && !tokens[i].equalsIgnoreCase("null")) {
                        cur.right = new TreeNode(Integer.parseInt(tokens[i]));
                        q.add(cur.right);
                    }
                    i++;
                }
            }
        }
        Solution sol = new Solution();
        System.out.println("Is the tree a valid BST?: " + sol.isValidBST(root));

        sc.close();
    }
}