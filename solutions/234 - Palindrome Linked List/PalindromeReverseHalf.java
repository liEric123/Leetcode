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
    public boolean isPalindrome(ListNode head) {
        // Time Complexity: O(N) to reverse half of the linked list and then check if palindrome.
        // Space Complexity: O(1) for a few pointers.

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is not at the center.
        // We will reverse everything after and including slow.

        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        // Now prev is the head of the reversed second half of the list.

        // Check both halves. If palindrom, they should be equal.
        while (prev != null && head != null) {
            if (prev.val != head.val) {
                return false;
            }
            prev = prev.next;
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter linked list: ");
        String line = sc.nextLine();
    
        String[] parts = line.split(" ");
    
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
    
        for (int i = 0; i < parts.length; i++) {
            curr.next = new ListNode(Integer.parseInt(parts[i]));
            curr = curr.next;
        }
    
        Solution sol = new Solution();
        boolean result = sol.isPalindrome(dummy.next);
    
        System.out.println("Is palindrome: ");
        System.out.println(result);
    
        sc.close();
    }
}