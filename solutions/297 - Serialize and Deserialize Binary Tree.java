import java.util.*;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Time Complexity: O(N) to serialize every node in the tree.
        // Space Complexity: O(N) for output string and recursion stack.
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N").append(",");
            return;
        }

        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Time Complexity: O(N) to deserialize every node in the tree.
        // Space Complexity: O(N) for tokens array, Queue, and recursion stack.
        String[] tokens = data.split(",");
        Queue<String> queue = new ArrayDeque<>();

        for (String s : tokens) {
            queue.offer(s);
        }
        return deserializeHelper(queue);
    }

    // Every call returns and consumes one token from the queue.
    // We use a queue so we don't have to keep track of where in the String we are.
    private TreeNode deserializeHelper(Queue<String> queue) {
        String curr = queue.poll();
        if (curr.equals("N")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter tree: ");
        String line = sc.nextLine().trim();
    
        TreeNode root = null;
    
        if (!line.isEmpty() && !line.equals("null")) {
            String[] parts = line.split("\\s+");
    
            root = new TreeNode(Integer.parseInt(parts[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
    
            int i = 1;
            while (!queue.isEmpty() && i < parts.length) {
                TreeNode curr = queue.poll();
    
                if (i < parts.length && !parts[i].equals("null")) {
                    curr.left = new TreeNode(Integer.parseInt(parts[i]));
                    queue.offer(curr.left);
                }
                i++;
    
                if (i < parts.length && !parts[i].equals("null")) {
                    curr.right = new TreeNode(Integer.parseInt(parts[i]));
                    queue.offer(curr.right);
                }
                i++;
            }
        }
    
        Codec codec = new Codec();
    
        String serialized = codec.serialize(root);
        TreeNode deserialized = codec.deserialize(serialized);
        String reserialized = codec.serialize(deserialized);
    
        System.out.println("Serialized: ");
        System.out.println(serialized);
    
        System.out.println("Serialized after deserialize: ");
        System.out.println(reserialized);
    
        sc.close();
    }
}