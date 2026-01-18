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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Time Complexity: O(N) because each node is accessed a constant number of times.
        //                  They are accessed while checking and reversing.
        // Space Complexity: O(1) for a few pointers
        // DummyAns is used to handle edge cases, making out lives easier.
        ListNode dummyAns = new ListNode();
        dummyAns.next = head;
        // Track the previous node before the current group.
        ListNode prevGroupTail = dummyAns;
        // Essentially -> while (true) because prevGroupTail will never be null.
        while (prevGroupTail != null) {
            // 1. Prep for reversal:
            // We first try and loop k steps to see if we can make a group.
            // We will also save pointers to ensure the list is built correctly.
            ListNode iter = prevGroupTail;
            // Ensure we aren't on the last group.
            // iter ends up being the last node of current group.
            for (int i = 0; i < k; i++) {
                iter = iter.next;
                if (iter == null) {
                    return dummyAns.next;
                }
            }
            // Used for reversal process
            ListNode currGroupHead = prevGroupTail.next;
            // Track pointer for next group
            ListNode nextGroupHead = iter.next;
            // Link previous group to new head before reversal.
            prevGroupTail.next = iter;
            // 2. Start reversal process:
            // We will use a dummy to build the new list.
            // We will prepend nodes to the dummy, giving us a reversed order.
            // Be careful to only reverse k nodes
            ListNode dummyReverse = new ListNode();
            ListNode curr = currGroupHead;
            while (curr != nextGroupHead) {
                ListNode next = curr.next;
                curr.next = dummyReverse.next;
                dummyReverse.next = curr;
                curr = next;
            }
            // currGroupHead becomes the tail of this group so we connect it with the next group.
            currGroupHead.next = nextGroupHead;
            // Update prevGroupTail after done reversing.
            prevGroupTail = currGroupHead;
        }
        return dummyAns.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the linked list values: ");
        String line = sc.nextLine().trim();
    
        System.out.println("Enter k: ");
        int k = sc.nextInt();
    
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
    
        if (!line.isEmpty()) {
            String[] parts = line.split("\\s+");
            for (String p : parts) {
                tail.next = new ListNode(Integer.parseInt(p));
                tail = tail.next;
            }
        }
    
        Solution sol = new Solution();
        ListNode result = sol.reverseKGroup(dummy.next, k);
    
        System.out.println("Resulting list: ");
        ListNode curr = result;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" ");
            curr = curr.next;
        }
        System.out.println();
        sc.close();
    }    
}