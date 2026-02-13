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
    public List<Integer> rightSideView(TreeNode root) {
        // Time Complexity: O(N) because each node is visited once.
        // Space Complexity: O(W) where W is the max width of tree.
        //                   Worst case O(N) for complete binary tree.
        List<Integer> right = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (i == queueSize - 1) {
                    right.add(curr.val);
                }
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter tree values: ");
        String[] values = sc.nextLine().trim().split("\\s+");

        TreeNode root = null;
        if (values.length > 0 && !values[0].equals("null")) {
            root = new TreeNode(Integer.parseInt(values[0]));
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            int i = 1;
            while (!queue.isEmpty() && i < values.length) {
                TreeNode curr = queue.poll();

                if (i < values.length && !values[i].equals("null")) {
                    curr.left = new TreeNode(Integer.parseInt(values[i]));
                    queue.add(curr.left);
                }
                i++;

                if (i < values.length && !values[i].equals("null")) {
                    curr.right = new TreeNode(Integer.parseInt(values[i]));
                    queue.add(curr.right);
                }
                i++;
            }
        }

        Solution sol = new Solution();
        List<Integer> result = sol.rightSideView(root);

        System.out.println("Right side view: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
        
        sc.close();
    }
}