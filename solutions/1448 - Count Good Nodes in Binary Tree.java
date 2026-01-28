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
    private int totalGood = 0;
    public int goodNodes(TreeNode root) {
        // Time Complexity: O(N) because we visit each node once.
        // Space Complexity: O(H) for the recursion stack. O(N) worst case for skewed tree.
        dfs(root, Integer.MIN_VALUE);
        return totalGood;
    }
    private void dfs(TreeNode root, int maximum) {
        if (root == null) {
            return;
        }
        if (root.val >= maximum) {
            totalGood++;
        }
        dfs(root.left, Math.max(maximum, root.val));
        dfs(root.right, Math.max(maximum, root.val));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tree values: ");
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
        System.out.println("Number of good nodes: " + sol.goodNodes(root));

        sc.close();
    }
}