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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Time Complexity: O(N) because for each tree we visit every node once.
        // Space Complexity: O(H) for the recursion stack. O(N) worst case for skewed tree.
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
    
        System.out.println("Enter first tree values: ");
        String[] a = sc.nextLine().trim().split("\\s+");
    
        System.out.println("Enter second tree values: ");
        String[] b = sc.nextLine().trim().split("\\s+");
    
        TreeNode p = null;
        if (!a[0].equals("null")) {
            p = new TreeNode(Integer.parseInt(a[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.add(p);
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
    
        TreeNode r = null;
        if (!b[0].equals("null")) {
            r = new TreeNode(Integer.parseInt(b[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.add(r);
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
        System.out.println("Same Tree?: " + sol.isSameTree(p, r));
    
        sc.close();
    }    
}