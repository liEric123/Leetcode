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
        // Time Complexity: O(N) to store the nodes in the stack.
        //                  O(N) to rebuild the list pointers.
        // Space Complexity: O(N) since we store all nodes in a stack.
        if (head == null) {
            return null;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode curr = head;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        ListNode newHead = stack.pop();
        curr = newHead;

        while (!stack.isEmpty()) {
            ListNode nextNode = stack.pop();
            curr.next = nextNode;
            curr = nextNode;
        }
        curr.next = null;
        return newHead;
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