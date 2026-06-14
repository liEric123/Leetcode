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
    public int pairSum(ListNode head) {
        // Time Complexity: O(N) to find middle of list, build the stack, and find each twin sum.
        // Space Complexity: O(N) for the stack, which contains the first twin node values.

        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        int maxTwinSum = 0;
        while (!stack.isEmpty()) {
            int currTwinSum = stack.pop() + slow.val;
            maxTwinSum = Math.max(maxTwinSum, currTwinSum);

            slow = slow.next;
        }

        return maxTwinSum;
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
        int result = sol.pairSum(head);
    
        System.out.println("Maximum twin sum: ");
        System.out.println(result);
    
        sc.close();
    }
}