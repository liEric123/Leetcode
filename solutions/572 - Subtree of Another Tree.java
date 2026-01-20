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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Time Complexity: O(N * M) because we visit each node in root once.
        //                  And each time we check if the subtree at root is equal to subRoot.
        // Space Complexity: O(H) for the recursion stack. Worse case O(N) for skewed root.
        if (root == null) {
            return false;
        }
        // Subproblem is LC 100 - Same Tree.
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter root values: ");
        String[] a = sc.nextLine().trim().split("\\s+");
    
        System.out.println("Enter subRoot values: ");
        String[] b = sc.nextLine().trim().split("\\s+");
    
        TreeNode root = null;
        if (!a[0].equals("null")) {
            root = new TreeNode(Integer.parseInt(a[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            int i = 1;
            while (!q.isEmpty() && i < a.length) {
                TreeNode cur = q.poll();
                if (i < a.length && !a[i].equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(a[i]));
                    q.add(cur.left);
                }
                i++;
                if (i < a.length && !a[i].equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(a[i]));
                    q.add(cur.right);
                }
                i++;
            }
        }
    
        TreeNode subRoot = null;
        if (!b[0].equals("null")) {
            subRoot = new TreeNode(Integer.parseInt(b[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.add(subRoot);
            int i = 1;
            while (!q.isEmpty() && i < b.length) {
                TreeNode cur = q.poll();
                if (i < b.length && !b[i].equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(b[i]));
                    q.add(cur.left);
                }
                i++;
                if (i < b.length && !b[i].equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(b[i]));
                    q.add(cur.right);
                }
                i++;
            }
        }
    
        Solution sol = new Solution();
        System.out.println("Subtree?: " + sol.isSubtree(root, subRoot));
        sc.close();
    }    
}