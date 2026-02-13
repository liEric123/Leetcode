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
    public int kthSmallest(TreeNode root, int k) {
        // Time Complexity: O(N) because each node is visited at most twice.
        //                  Once when it is the predecessor, again when visiting it.
        // Space Complexity: O(1) for a few pointers only. No recursion stack.
        // Morris Traversal simulating In-order in constant time.
        TreeNode curr = root;
        while (curr != null) {
            // If no left node, visit curr node.
            // Then move to the right node.
            if (curr.left == null) {
                k--;
                if (k == 0) {
                    return curr.val;
                }
                curr = curr.right;
            } else {
                // Find predecessor (rightmost node in left subtree).
                // This is the greatest node smaller than itself.
                // Create a thread from predecessor right pointer to curr.
                // Let's us backtrack after finished with left subtree without stack or recursion.
                // Use right pointer because its guaranteed to be safe.
                TreeNode predecessor = curr.left;
                // This loop conditions lets us stop at the predecessor exactly.
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    // Set the thread, continue inorder traversal.
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    // Break the thread, visit curr now, and go to right subtree, as left is done.
                    predecessor.right = null;
                    k--;
                    if (k == 0) {
                        return curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        // If k was out of bounds.
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tree values: ");
        String s = sc.nextLine().trim();

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        if (s.isEmpty()) {
            System.out.println("kth smallest element: -1");
            sc.close();
            return;
        }

        String[] parts = s.split("\\s+");

        TreeNode root = new TreeNode(Integer.parseInt(parts[0].trim()));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < parts.length) {
            TreeNode node = q.poll();

            if (i < parts.length && !parts[i].trim().equals("null")) {
                node.left = new TreeNode(Integer.parseInt(parts[i].trim()));
                q.offer(node.left);
            }
            i++;

            if (i < parts.length && !parts[i].trim().equals("null")) {
                node.right = new TreeNode(Integer.parseInt(parts[i].trim()));
                q.offer(node.right);
            }
            i++;
        }

        Solution sol = new Solution();
        System.out.println("kth smallest element: " + sol.kthSmallest(root, k));

        sc.close();
    }
}