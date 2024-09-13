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
    public boolean isPalindrome(ListNode head) {
        StringBuilder a=new StringBuilder();
        ListNode curr=head;
        while(curr!=null){
            a.append(curr.val);
            curr=curr.next;
        }
        String input=a.toString();
        int l=0;
        int h=input.length()-1;
        while(l<h){
            if(input.charAt(l)!=input.charAt(h)){
                return false;
            }
            l++;
            h--;
        }

        return true;

    }
}