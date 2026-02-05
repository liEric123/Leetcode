import java.util.*;
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        // Time Complexity: O(N) since each node is visited once.
        // Space Complexity: O(1) for a few pointers.
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter linked list elements: ");
        String line = sc.nextLine();
        String[] values = line.trim().split("\\s+");

        ListNode head = null;
        ListNode tail = null;

        for (String v : values) {
            int val = Integer.parseInt(v);
            ListNode node = new ListNode(val);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        Solution sol = new Solution();
        ListNode reversedHead = sol.reverseList(head);

        ListNode curr = reversedHead;
        System.out.print("Reversed list: ");
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
        
        sc.close();
    }
}