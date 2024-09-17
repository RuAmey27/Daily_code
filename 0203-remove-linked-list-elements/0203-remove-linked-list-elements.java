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
    public ListNode removeElements(ListNode head, int val) {
      if (head == null) {
            return null;
        }
        
        // Check if the current node needs to be removed
        if (head.val == val) {
            // Skip the current node and process the rest of the list
            return removeElements(head.next, val);
        } else {
            // Recursively call removeElements for the next node
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}