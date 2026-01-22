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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Time Complexity: O(N) because we visit each node once.
        // Space Complexity: O(N) for the answer and queue.
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            ans.add(currLevel);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter binary tree: ");
        String line = sc.nextLine().trim();

        if (line.isEmpty() || line.equals("[]")) {
            System.out.println("Output:");
            System.out.println("[]");
            sc.close();
            return;
        }

        String[] values = line.split("\\s+");
        TreeNode root = null;

        if (!values[0].equalsIgnoreCase("null")) {
            root = new TreeNode(Integer.parseInt(values[0]));
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);

            int i = 1;
            while (!q.isEmpty() && i < values.length) {
                TreeNode cur = q.poll();

                if (i < values.length && !values[i].equalsIgnoreCase("null")) {
                    cur.left = new TreeNode(Integer.parseInt(values[i]));
                    q.add(cur.left);
                }
                i++;

                if (i < values.length && !values[i].equalsIgnoreCase("null")) {
                    cur.right = new TreeNode(Integer.parseInt(values[i]));
                    q.add(cur.right);
                }
                i++;
            }
        }

        Solution sol = new Solution();
        List<List<Integer>> res = sol.levelOrder(root);

        System.out.println("Output: ");
        for (List<Integer> level : res) {
            for (int v : level) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}