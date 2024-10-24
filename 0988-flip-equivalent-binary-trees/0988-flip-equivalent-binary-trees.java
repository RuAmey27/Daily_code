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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // If both roots are null, they are equivalent
        if (root1 == null && root2 == null) {
            return true;
        }
        // If one of the roots is null or the values don't match, they are not equivalent
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        // Check for flip equivalence in two cases:
        // 1. Without flipping: left child matches left, right matches right.
        // 2. With flipping: left child matches right, right matches left.
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
               (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
