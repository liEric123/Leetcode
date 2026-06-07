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
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Time Complexity: O(N) to process each description once and loop over the nodes.
        // Space Complexity: O(N) for the map and set of nodes.
        // Maps values to their respective nodes.
        Map<Integer, TreeNode> nodes = new HashMap<>();
        // Used to find the root of the tree to return.
        Set<Integer> childNodes = new HashSet<>();

        for (int[] i : descriptions) {
            if (!nodes.containsKey(i[0])) {
                nodes.put(i[0], new TreeNode(i[0]));
            }

            if (!nodes.containsKey(i[1])) {
                nodes.put(i[1], new TreeNode(i[1]));
            }

            childNodes.add(i[1]);
            if (i[2] == 1) {
                nodes.get(i[0]).left = nodes.get(i[1]);
            } else {
                nodes.get(i[0]).right = nodes.get(i[1]);
            }
        }

        // The root is the only one that isn't a child node.
        for (int i : nodes.keySet()) {
            if (!childNodes.contains(i)) {
                return nodes.get(i);
            }
        }

        // Should never reach here.
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter descriptions line by line: ");
        System.out.println("Enter done to finish: ");

        List<int[]> list = new ArrayList<>();

        while (true) {
            String line = sc.nextLine().trim();

            if (line.equals("done")) {
                break;
            }

            String[] parts = line.split(" ");
            int[] row = new int[3];
            row[0] = Integer.parseInt(parts[0]);
            row[1] = Integer.parseInt(parts[1]);
            row[2] = Integer.parseInt(parts[2]);
            list.add(row);
        }

        int[][] descriptions = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            descriptions[i] = list.get(i);
        }

        Solution sol = new Solution();
        TreeNode root = sol.createBinaryTree(descriptions);

        System.out.println("Tree level order: ");
        if (root == null) {
            System.out.println("[]");
            sc.close();
            return;
        }

        List<String> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                result.add("null");
            } else {
                result.add(String.valueOf(curr.val));
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }

        while (!result.isEmpty() && result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }

        System.out.println(result);
        sc.close();
    }
}