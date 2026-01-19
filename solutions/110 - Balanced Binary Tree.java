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
    public boolean isBalanced(TreeNode root) {
        // -1 if unbalanced, height of tree if balanced.
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        // Time Complexity: O(N) because we visit each node once in dfs.
        // Space Complexity: O(H) for recursion stack. O(N) worse case for skewed tree.
        if (root == null) {
            return 0;
        }
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        // Bubble up failure if unbalanced.
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // If not unbalanced, return height of subtree.
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter tree values: ");
        String[] a = sc.nextLine().trim().split("\\s+");
        sc.close();
    
        if (a.length == 0 || a[0].equals("null")) {
            System.out.println(true);
            return;
        }
    
        TreeNode root = new TreeNode(Integer.parseInt(a[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
    
        for (int i = 1; i < a.length; i++) {
            TreeNode cur = q.poll();
            if (!a[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(a[i]));
                q.add(cur.left);
            }
            if (++i < a.length && !a[i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(a[i]));
                q.add(cur.right);
            }
        }
    
        System.out.println(new Solution().isBalanced(root));
    }    
}