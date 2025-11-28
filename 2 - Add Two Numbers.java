/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Time Complexity: O(max(M, N)) because we iterate over both lists at the same time.
        // Space Complexity O(max(M, N)) for the answer List.
        int carry = 0;
        ListNode it1 = l1;
        ListNode it2 = l2;
        ListNode answer = new ListNode();
        ListNode answerIt = answer;
        while (it1 != null && it2 != null) {
            int sum = it1.val + it2.val + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            if (sum >= 10) {
                sum %= 10;
            }
            System.out.println(sum);
            answerIt.next = new ListNode(sum);
            answerIt = answerIt.next;
            it1 = it1.next;
            it2 = it2.next;
        }
        while (it1 == null && it2 != null) {
            int sum = it2.val + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            if (sum >= 10) {
                sum %= 10;
            }
            answerIt.next = new ListNode(sum);
            answerIt = answerIt.next;
            it2 = it2.next;
        }
        while (it2 == null && it1 != null) {
            int sum = it1.val + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            if (sum >= 10) {
                sum %= 10;
            }
            answerIt.next = new ListNode(sum);
            answerIt = answerIt.next;
            it1 = it1.next;
        }
        if (carry != 0) {
            answerIt.next = new ListNode(carry);
        }
        return answer.next;
    }
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        Solution s = new Solution();

        System.out.println("Enter digits for list 1 (space-separated):");
        String[] a = sc.nextLine().split(" ");

        Solution.ListNode l1 = null, tail1 = null;
        for (String x : a) {
            Solution.ListNode node = s.new ListNode(Integer.parseInt(x));
            if (l1 == null) {
                l1 = node;
                tail1 = node;
            } else {
                tail1.next = node;
                tail1 = node;
            }
        }

        System.out.println("Enter digits for list 2 (space-separated):");
        String[] b = sc.nextLine().split(" ");

        Solution.ListNode l2 = null, tail2 = null;
        for (String x : b) {
            Solution.ListNode node = s.new ListNode(Integer.parseInt(x));
            if (l2 == null) {
                l2 = node;
                tail2 = node;
            } else {
                tail2.next = node;
                tail2 = node;
            }
        }

        Solution.ListNode result = s.addTwoNumbers(l1, l2);

        System.out.print("Result: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
    }
}