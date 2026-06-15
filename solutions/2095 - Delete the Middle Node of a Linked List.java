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
    public ListNode deleteMiddle(ListNode head) {
        // Time Complexity: O(N) for fast and slow pointers and to find the slowPrev pointer.
        // Space Complexity: O(1) for a few pointers.

        // Edge case where slowPrev doesn't work.
        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Find the node before the middle node for surgery.
        ListNode slowPrev = head;
        while (slowPrev.next != slow && slowPrev.next != null) {
            slowPrev = slowPrev.next;
        }
        slowPrev.next = slow.next;
        // Optional cleanup.
        slow.next = null;

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter linked list: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
    
        ListNode head = null;
        ListNode tail = null;
    
        for (int i = 0; i < parts.length; i++) {
            ListNode node = new ListNode(Integer.parseInt(parts[i]));
    
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }
    
        Solution sol = new Solution();
        ListNode result = sol.deleteMiddle(head);
    
        System.out.println("List after deleting middle: ");
        while (result != null) {
            System.out.print(result.val);
    
            if (result.next != null) {
                System.out.print(" ");
            }
    
            result = result.next;
        }
        System.out.println();
    
        sc.close();
    }
}