import java.util.*;
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        // Time Complexity: O(N) because tortoise and hare guaranteed to meet within L + C steps
        // where L is the steps to the cycle entry and C is the cycle length. This is less than N.
        // Time Complexity: O(N) for a few pointer variables.
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                return false;
            }
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the list: ");
        String line = sc.nextLine();

        System.out.println("Enter the cycle position: ");
        int pos = sc.nextInt();

        String[] parts = line.trim().isEmpty() ? new String[0] : line.split(" ");
        ListNode head = null;
        ListNode tail = null;
        ListNode cycleNode = null;

        for (int i = 0; i < parts.length; i++) {
            ListNode node = new ListNode(Integer.parseInt(parts[i]));
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
            if (i == pos) {
                cycleNode = node;
            }
        }

        if (tail != null && pos >= 0 && pos < parts.length) {
            tail.next = cycleNode;
        }

        Solution sol = new Solution();
        boolean result = sol.hasCycle(head);

        System.out.println("Has cycle?: ");
        System.out.println(result);

        sc.close();
    }
}