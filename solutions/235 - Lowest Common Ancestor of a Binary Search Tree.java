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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Time Complexity: O(H) because we don't need to visit each node.
        //                  Since it is a BST, we only need to visit one node per level.
        // Space Complexity: O(H) for recursion stack. Worse case O(N) for skewed tree.
        // If root is the split or equal to either p or q.
        if (root.val > p.val && root.val < q.val
            || root.val < p.val && root.val > q.val
            || root.val == p.val || root.val == q.val) {
            return root;
        }
        if (root.val > p.val) {
            // If root is greater than both p and q, search in left subtree.
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // If root is less than both p and q, search in right subtree.
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter tree values: ");
        String[] a = sc.nextLine().trim().split("\\s+");
    
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
    
        System.out.println("Enter p: ");
        int pVal = sc.nextInt();
    
        System.out.println("Enter q: ");
        int qVal = sc.nextInt();
    
        TreeNode p = new TreeNode(pVal);
        TreeNode qNode = new TreeNode(qVal);
    
        Solution sol = new Solution();
        TreeNode ans = sol.lowestCommonAncestor(root, p, qNode);
    
        System.out.println("LCA: " + ans.val);
    
        sc.close();
    }    
}