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
    public ListNode swapPairs(ListNode head) {
        ListNode temp=new ListNode(-1);
        temp.next=head;


        ListNode prev=temp;
        ListNode curr=head;

        while(curr!=null&& curr.next!=null){
            ListNode first =curr;
            ListNode second =curr.next;


            prev.next=second;
            first.next=second.next;
            second.next=first;

            prev=first;
            curr=first.next;
        }


        return temp.next;
    }
}