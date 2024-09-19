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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedValues = new ArrayList<>();
        inOrderTraversal(root, sortedValues);
        
        // The kth smallest element is at index k-1 in 0-indexed list
        return sortedValues.get(k - 1);
    }
    
    private void inOrderTraversal(TreeNode node, List<Integer> sortedValues) {
        if (node == null) {
            return;
        }
        
        inOrderTraversal(node.left, sortedValues);
        sortedValues.add(node.val);
        inOrderTraversal(node.right, sortedValues);
    }
}