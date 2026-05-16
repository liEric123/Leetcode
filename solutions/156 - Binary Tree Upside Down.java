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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // Time Complexity: O(N) to process each node once.
        // Space Complexity: O(H) for recursion stack. O(N) worst case for skewed tree.
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the tree: ");
        String[] parts = sc.nextLine().split(" ");
    
        TreeNode root = null;
        if (!parts[0].equals("null")) {
            root = new TreeNode(Integer.parseInt(parts[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
    
            for (int i = 1; i < parts.length; ) {
                TreeNode curr = q.poll();
    
                if (i < parts.length && !parts[i].equals("null")) {
                    curr.left = new TreeNode(Integer.parseInt(parts[i]));
                    q.offer(curr.left);
                }
                i++;
    
                if (i < parts.length && !parts[i].equals("null")) {
                    curr.right = new TreeNode(Integer.parseInt(parts[i]));
                    q.offer(curr.right);
                }
                i++;
            }
        }
    
        Solution sol = new Solution();
        TreeNode ans = sol.upsideDownBinaryTree(root);
    
        System.out.println("Upside down tree: ");
        Queue<TreeNode> q = new LinkedList<>();
        if (ans != null) q.offer(ans);
    
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
    
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }

        System.out.println();
        sc.close();
    }
}