/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         if (headA == null || headB == null) {
            return null;
        }

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        // Step 1: Calculate lengths of both linked lists
        int lenA = 0, lenB = 0;
        
        while (ptrA != null) {
            lenA++;
            ptrA = ptrA.next;
        }
        
        while (ptrB != null) {
            lenB++;
            ptrB = ptrB.next;
        }

        // Step 2: Align the starting point
        ptrA = headA;
        ptrB = headB;
        
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                ptrA = ptrA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                ptrB = ptrB.next;
            }
        }

        // Step 3: Find the intersection
        while (ptrA != null && ptrB != null) {
            if (ptrA == ptrB) {
                return ptrA; // Intersection node found
            }
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        return null; // No intersection
    }
}