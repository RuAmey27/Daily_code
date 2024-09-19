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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Dummy node to simplify code
        ListNode current = dummyHead;
        int carry = 0;
        
        // Traverse both lists
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0; // Get the value of the current node in l1 or 0 if l1 is null
            int y = (l2 != null) ? l2.val : 0; // Get the value of the current node in l2 or 0 if l2 is null
            int sum = x + y + carry; // Add values and carry
            carry = sum / 10; // Update carry for the next iteration
            current.next = new ListNode(sum % 10); // Create a new node with the digit (sum % 10)
            current = current.next; // Move to the next node
            
            if (l1 != null) l1 = l1.next; // Move to the next node in l1 if available
            if (l2 != null) l2 = l2.next; // Move to the next node in l2 if available
        }
        
        // If there is a carry left after the last addition, add it as a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        return dummyHead.next; // Return 
    }
}