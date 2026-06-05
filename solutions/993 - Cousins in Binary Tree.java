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
    public boolean isCousins(TreeNode root, int x, int y) {
        // Time Complexity: O(N) since every node might be visited once during BFS.
        // Space Complexity: O(W) for the queue of nodes on the same level. Worst case O(N).
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            boolean xFound = false;
            boolean yFound = false;
            for (int i = 0; i < sz; i++) {
                TreeNode curr = q.poll();
                if (curr.val == x) {
                    xFound = true;
                } else if (curr.val == y) {
                    yFound = true;
                }

                // When might they not be cousins?
                // If they are on the same level and are siblings
                // or if they are not on the same level.
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) ||
                        (curr.right.val == x && curr.left.val == y)) {
                        return false;
                    }
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            
            if (xFound ^ yFound) {
                return false;
            }
            if (xFound && yFound) {
                // Can be certain they aren't siblings.
                return true;
            }
        }
        // Shouldn't even reach here under constraints.
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tree level order: ");
        String[] values = sc.nextLine().trim().split("\\s+");

        TreeNode root = null;
        if (!values[0].equals("null")) {
            root = new TreeNode(Integer.parseInt(values[0]));
            Queue<TreeNode> q = new ArrayDeque<>();
            q.offer(root);

            int i = 1;
            while (!q.isEmpty() && i < values.length) {
                TreeNode curr = q.poll();

                if (i < values.length && !values[i].equals("null")) {
                    curr.left = new TreeNode(Integer.parseInt(values[i]));
                    q.offer(curr.left);
                }
                i++;

                if (i < values.length && !values[i].equals("null")) {
                    curr.right = new TreeNode(Integer.parseInt(values[i]));
                    q.offer(curr.right);
                }
                i++;
            }
        }

        System.out.println("Enter x:");
        int x = Integer.parseInt(sc.nextLine());

        System.out.println("Enter y:");
        int y = Integer.parseInt(sc.nextLine());

        Solution sol = new Solution();
        boolean result = sol.isCousins(root, x, y);

        System.out.println("Are cousins:");
        System.out.println(result);

        sc.close();
    }
}