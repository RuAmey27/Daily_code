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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        
        int baseLen = length / k;
        int extraNodes = length % k;
        
        ListNode[] parts = new ListNode[k];
        current = head;
        
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            ListNode partTail = null;
            
            int currentPartLen = baseLen + (extraNodes > 0 ? 1 : 0);
            if (extraNodes > 0) {
                extraNodes--;
            }
            
            for (int j = 0; j < currentPartLen; j++) {
                if (current != null) {
                    partTail = current;
                    current = current.next;
                }
            }
            
            if (partTail != null) {
                partTail.next = null;
            }
            
            parts[i] = partHead;
        }
        
        return parts;
    }
}