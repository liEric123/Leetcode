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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Time Complexity: O(N) since constant operations on each node. Creation and threading.
        // Space Complexity: O(1) excluding output tree for the temporary threads.
        int treeSz = preorder.length;
        if (treeSz == 0) {
            return null;
        }
        TreeNode root = new TreeNode(0);
        TreeNode curr = root;
        int preIt = 0; // preorder node to create
        int inIt = 0;  // inorder node to close

        while (preIt < treeSz && inIt < treeSz) {
            // Use rights pointers like a stack.
            // Since preorder, we go node->left->right.
            // When done with left subtree, return to parent to build right subtree.
            // When done with right subtree, return to parent's return target.
            curr.right = new TreeNode(preorder[preIt++], null, curr.right);
            curr = curr.right;
            // Build left until inorder reached.
            while (preIt < treeSz && curr.val != inorder[inIt]) {
                curr.left = new TreeNode(preorder[preIt++], null, curr);
                curr = curr.left;
            }
            inIt++;
            // Unwind threads now.
            while (inIt < treeSz && curr.right != null && curr.right.val == inorder[inIt]) {
                TreeNode parent = curr.right;
                curr.right = null;
                curr = parent;
                inIt++;
            }
        }

        return root.right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter preorder values: ");
        String preorderLine = sc.nextLine().trim();
    
        System.out.println("Enter inorder values: ");
        String inorderLine = sc.nextLine().trim();
    
        int[] preorder;
        if (preorderLine.isEmpty()) {
            preorder = new int[0];
        } else {
            String[] p = preorderLine.split("\\s+");
            preorder = new int[p.length];
            for (int i = 0; i < p.length; i++) preorder[i] = Integer.parseInt(p[i]);
        }
    
        int[] inorder;
        if (inorderLine.isEmpty()) {
            inorder = new int[0];
        } else {
            String[] in = inorderLine.split("\\s+");
            inorder = new int[in.length];
            for (int i = 0; i < in.length; i++) inorder[i] = Integer.parseInt(in[i]);
        }
    
        if (preorder.length != inorder.length) {
            System.out.println("Ensure preorder and inorder have the same number of values.");
            sc.close();
            return;
        }
    
        TreeNode root = new Solution().buildTree(preorder, inorder);
    
        if (root == null) {
            System.out.println();
            sc.close();
            return;
        }
    
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<String> out = new ArrayList<>();
    
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                out.add("null");
            } else {
                out.add(String.valueOf(node.val));
                q.add(node.left);
                q.add(node.right);
            }
        }
    
        int k = out.size() - 1;
        while (k >= 0 && out.get(k).equals("null")) k--;
    
        System.out.println("Resulting tree: ");
        for (int i = 0; i <= k; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(out.get(i));
        }
        System.out.println();
    
        sc.close();
    }
}