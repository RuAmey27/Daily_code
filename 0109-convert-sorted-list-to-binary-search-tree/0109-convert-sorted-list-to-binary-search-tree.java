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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return buildBST(head, null);
    }

    private TreeNode buildBST(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }

        ListNode mid = findMiddle(start, end);
        TreeNode node = new TreeNode(mid.val);
        node.left = buildBST(start, mid);
        node.right = buildBST(mid.next, end);

        return node;
    }

    private ListNode findMiddle(ListNode start, ListNode end) {
        ListNode slow = start;
        ListNode fast = start;

        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
