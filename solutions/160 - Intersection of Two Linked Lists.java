import java.util.*;
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Time Complexity: O(M + N) since pointers walk both lists.
        //                  If there is an intersection, then they will meet there. Otherwise, null.
        // Space Complexity: O(1) for a few pointers.
        ListNode p1 = headA;
        ListNode p2 = headB;

        // Let a be the listA before intersection, b be the listB before intersection, and c be
        // the list after the intersection.
        // Let's say ListA length is longer than ListB length.
        // Then Pointer1 walks a + c and then resets to listB to walk b.
        // Pointer2 walks a + c + b as well. Rearranging (b + c) + a.
        // If there is an intersection, they will meet there.
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter listA: ");
        String lineA = sc.nextLine().trim();
    
        System.out.println("Enter listB: ");
        String lineB = sc.nextLine().trim();
    
        System.out.println("Enter skipA: ");
        int skipA = Integer.parseInt(sc.nextLine().trim());
    
        System.out.println("Enter skipB: ");
        int skipB = Integer.parseInt(sc.nextLine().trim());
    
        String[] partsA = lineA.split("\\s+");
        String[] partsB = lineB.split("\\s+");
    
        ListNode headA = null;
        ListNode tailA = null;
        ListNode intersectNode = null;
    
        for (int i = 0; i < partsA.length; i++) {
            ListNode node = new ListNode(Integer.parseInt(partsA[i]), null);
    
            if (headA == null) {
                headA = node;
                tailA = node;
            } else {
                tailA.next = node;
                tailA = tailA.next;
            }
    
            if (i == skipA) {
                intersectNode = node;
            }
        }
    
        ListNode headB = null;
        ListNode tailB = null;
    
        for (int i = 0; i < partsB.length && i < skipB; i++) {
            ListNode node = new ListNode(Integer.parseInt(partsB[i]), null);
    
            if (headB == null) {
                headB = node;
                tailB = node;
            } else {
                tailB.next = node;
                tailB = tailB.next;
            }
        }
    
        if (skipA < partsA.length && skipB < partsB.length) {
            if (headB == null) {
                headB = intersectNode;
            } else {
                tailB.next = intersectNode;
            }
        } else {
            for (int i = skipB; i < partsB.length; i++) {
                ListNode node = new ListNode(Integer.parseInt(partsB[i]), null);
    
                if (headB == null) {
                    headB = node;
                    tailB = node;
                } else {
                    tailB.next = node;
                    tailB = tailB.next;
                }
            }
        }
    
        Solution sol = new Solution();
        ListNode result = sol.getIntersectionNode(headA, headB);
    
        System.out.println("Intersection: ");
        if (result == null) {
            System.out.println("null");
        } else {
            System.out.println(result.val);
        }
    
        sc.close();
    }
}