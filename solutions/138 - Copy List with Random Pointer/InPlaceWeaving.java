import java.util.*;
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        // Time Complexity: O(N) to weave nodes, assign random pointers, and unweave lists.
        // Space Complexity: O(1) for a few pointers.
        Node temp = head;
        // Weave nodes to avoid using extra space.
        while (temp != null) {
            Node currCopy = new Node(temp.val);
            currCopy.next = temp.next;
            temp.next = currCopy;
            temp = currCopy.next;
        }
        // Now assign random pointer to each node.
        temp = head;
        while (temp != null) {
            Node currCopy = temp.next;
            if (temp.random == null) {
                currCopy.random = null;
                temp = currCopy.next;
                continue;
            }
            currCopy.random = temp.random.next;
            temp = currCopy.next;
        }
        // Unweave the list
        // dummy helps build the copied list
        Node dummy = new Node(0);
        Node dummyTail = dummy;
        // temp restores the original list
        temp = head;
        while (temp != null) {
            // currCopy is the copied of the origianl node
            Node currCopy = temp.next;
            // next is the next original node
            Node next = temp.next.next;
            // build
            dummyTail.next = currCopy;
            // advance
            dummyTail = currCopy;
            // restore
            temp.next = next;
            // advance
            temp = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter node values: ");
        String[] values = sc.nextLine().trim().split("\\s+");

        if (values.length == 1 && values[0].isEmpty()) {
            System.out.println("null");
            sc.close();
            return;
        }

        System.out.println("Enter random pointer indices (-1 for null): ");
        String[] randoms = sc.nextLine().trim().split("\\s+");

        int n = values.length;
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(Integer.parseInt(values[i]));
        }

        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        for (int i = 0; i < n; i++) {
            int r = Integer.parseInt(randoms[i]);
            if (r != -1) {
                nodes[i].random = nodes[r];
            }
        }

        Solution sol = new Solution();
        Node copiedHead = sol.copyRandomList(nodes[0]);

        Map<Node, Integer> indexMap = new HashMap<>();
        Node curr = copiedHead;
        int idx = 0;
        while (curr != null) {
            indexMap.put(curr, idx++);
            curr = curr.next;
        }

        System.out.println("Copied list: ");
        curr = copiedHead;
        while (curr != null) {
            int randomIdx = curr.random == null ? -1 : indexMap.get(curr.random);
            System.out.println(curr.val + " " + randomIdx);
            curr = curr.next;
        }
        sc.close();
    }
}