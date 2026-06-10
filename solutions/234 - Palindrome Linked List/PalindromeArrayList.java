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
        // Time Complexity: O(N) to copy the linked list into an ArrayList
        //                  and to check if it is a palindrome.
        // Space Complexity: O(N) for the copied list.

        ArrayList<Integer> linkedList = new ArrayList<>();
        while (head != null) {
            linkedList.add(head.val);
            head = head.next;
        }

        int l = 0;
        int r = linkedList.size() - 1;
        while (l < r) {
            if (linkedList.get(l) != linkedList.get(r)) {
                return false;
            }
            l++;
            r--;
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