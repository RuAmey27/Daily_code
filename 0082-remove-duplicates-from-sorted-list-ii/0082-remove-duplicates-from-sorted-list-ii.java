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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=new ListNode(-1);
        temp.next=head;

        ListNode behind=temp;
        ListNode front=head;

        while(front!=null){
            boolean duplicate=false;

            while(front.next!=null&& front.val==front.next.val){
                front=front.next;
                duplicate=true;
            }

            if(duplicate){
                behind.next=front.next;
            }else{
                behind=behind.next;
            }


            front=front.next;
        }

        return temp.next;

    }
}