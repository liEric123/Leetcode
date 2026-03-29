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
    public ListNode detectCycle(ListNode head) {
        // Time Complexity: O(N) because tortoise and hare guaranteed to meet within L + C steps
        // where L is the steps to the cycle entry and C is the cycle length. This is less than N.
        // Then finding the entry takes O(L). So overall O(N).
        // Space Complexity: O(1) for a few pointer variables.
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the list: ");
        String line = sc.nextLine().trim();
    
        ListNode head = null;
        ListNode tail = null;
    
        if (!line.isEmpty()) {
            String[] parts = line.split(" ");
            for (String part : parts) {
                ListNode node = new ListNode(Integer.parseInt(part));
                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
            }
        }
    
        System.out.println("Enter cycle pos: ");
        int pos = Integer.parseInt(sc.nextLine().trim());
    
        if (head != null && pos >= 0) {
            ListNode curr = head;
            ListNode cycleStart = null;
            int index = 0;
            while (curr.next != null) {
                if (index == pos) {
                    cycleStart = curr;
                }
                curr = curr.next;
                index++;
            }
            if (index == pos) {
                cycleStart = curr;
            }
            curr.next = cycleStart;
        }
    
        Solution sol = new Solution();
        ListNode result = sol.detectCycle(head);
    
        System.out.println("Tail connects to node index:");
        if (result == null) {
            System.out.println(-1);
        } else {
            ListNode curr = head;
            int index = 0;
            while (curr != result) {
                curr = curr.next;
                index++;
            }
            System.out.println(index);
        }
    
        sc.close();
    }
}