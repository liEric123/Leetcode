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
    public TreeNode invertTree(TreeNode root) {
        // Time Complexity: O(N) since we visit each node once. 
        // Space Complexity: O(H) for the call stack. Worse case O(N).
        dfs(root);
        return root;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // no need for null checks.
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter level-order tree (use null):");
        String[] values = sc.nextLine().trim().split("\\s+");
    
        if (values.length == 0 || values[0].equals("null")) {
            System.out.println("[]");
            return;
        }
    
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
    
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode curr = queue.poll();
    
            if (i < values.length && !values[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(curr.left);
            }
            i++;
    
            if (i < values.length && !values[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(curr.right);
            }
            i++;
        }
    
        Solution sol = new Solution();
        sol.invertTree(root);
    
        List<String> result = new ArrayList<>();
        queue.clear();
        queue.offer(root);
    
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(curr.val));
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
    
        int j = result.size() - 1;
        while (j >= 0 && result.get(j).equals("null")) {
            result.remove(j--);
        }
    
        System.out.println(result);
    }    
}