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
    public TreeNode replaceValueInTree(TreeNode root) {
        // Time Complexity: O(N) to loop over the tree, level by level.
        //                  For each node, we sum its value for the level sum and sibling sum.
        // Space Complexity: O(N) for the BFS queue.

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            int sumAll = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    sumAll += currNode.left.val;
                }
                if (currNode.right != null) {
                    sumAll += currNode.right.val;
                }

                queue.offer(currNode);
            }

            for (int i = 0; i < sz; i++) {
                TreeNode currNode = queue.poll();
                int childrenSum = 0;
                if (currNode.left != null) {
                    childrenSum += currNode.left.val;
                }

                if (currNode.right != null) {
                    childrenSum += currNode.right.val;
                }

                if (currNode.left != null) {
                    currNode.left.val = sumAll - childrenSum;
                    queue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    currNode.right.val = sumAll - childrenSum;
                    queue.offer(currNode.right);
                }
            }
        }

        root.val = 0;
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter tree: ");
        String[] parts = sc.nextLine().split(" ");
        if (parts[0].equals("null")) {
            System.out.println("null");
            sc.close();
            return;
        }
    
        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
    
        int i = 1;
        while (!q.isEmpty() && i < parts.length) {
            TreeNode node = q.poll();
    
            if (i < parts.length && !parts[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(parts[i]));
                q.offer(node.left);
            }
            i++;
    
            if (i < parts.length && !parts[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(parts[i]));
                q.offer(node.right);
            }
            i++;
        }
    
        Solution sol = new Solution();
        root = sol.replaceValueInTree(root);
    
        System.out.println("Answer: ");
        List<String> ans = new ArrayList<>();
        Queue<TreeNode> out = new LinkedList<>();
        out.offer(root);
    
        while (!out.isEmpty()) {
            TreeNode node = out.poll();
    
            if (node == null) {
                ans.add("null");
            } else {
                ans.add(String.valueOf(node.val));
                out.offer(node.left);
                out.offer(node.right);
            }
        }
    
        int end = ans.size() - 1;
        while (end >= 0 && ans.get(end).equals("null")) {
            end--;
        }
    
        for (int j = 0; j <= end; j++) {
            System.out.print(ans.get(j));
            if (j < end) {
                System.out.print(" ");
            }
        }
        System.out.println();
    
        sc.close();
    }
}