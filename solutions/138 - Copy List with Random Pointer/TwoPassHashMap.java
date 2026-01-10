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
        // Time Complexity: O(N) because we loop once to create the copies of each node in the map.
        //                  Then we loop again to assign the pointers to the copies.
        // Space Complexity: O(N) for the hashmap.
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node currCopy = map.get(temp);
            currCopy.next = map.get(temp.next);
            currCopy.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
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