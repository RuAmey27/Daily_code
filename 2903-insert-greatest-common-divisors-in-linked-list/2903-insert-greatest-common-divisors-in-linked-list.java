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
    private int gcd(int x,int y){
        while(y!=0){
            int temp=y;
            y=x%y;
            x=temp;
        }
        return x;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode retval=head;

        ListNode Node1=head;
        ListNode Node2=Node1.next;


        while(Node2!=null){
            ListNode gcdNode=new ListNode(gcd(Node1.val,Node2.val));

            gcdNode.next=Node2;
            Node1.next=gcdNode;

            Node1=Node2;
            Node2=Node1.next;
        }
        return retval;
    }
}