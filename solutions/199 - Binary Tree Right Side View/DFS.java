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
        // Time Complexity: O(N) because every node is visited once.
        // Space Complexity: O(H) for the recursion stack. O(N) worst case for skewed tree.
        List<Integer> right = new ArrayList<>();
        if (root == null) {
            return right;
        }
        dfs(right, 1, root);
        return right;
    }

    private void dfs(List<Integer> right, int depth, TreeNode node) {
        if (node == null) {
            return;
        }
        if (right.size() == depth - 1) {
            right.add(node.val);
        }
        dfs(right, depth + 1, node.right);
        dfs(right, depth + 1, node.left);
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