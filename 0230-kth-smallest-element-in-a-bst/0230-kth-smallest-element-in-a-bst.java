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
     private void inOrderTraversal(TreeNode node, PriorityQueue<Integer> minHeap) {
        if (node == null) {
            return;
        }
        
        inOrderTraversal(node.left, minHeap);
        minHeap.offer(node.val);
        inOrderTraversal(node.right, minHeap);
    }
    public int kthSmallest(TreeNode root, int k) {
         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        inOrderTraversal(root, minHeap);
        
        int kthSmallest = -1;
        for (int i = 0; i < k; i++) {
            kthSmallest = minHeap.poll();
        }
        
        return kthSmallest;
    }
}