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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();
        
        // Find the path from LCA to startValue
        findPath(lca, startValue, pathToStart);
        
        // Find the path from LCA to destValue
        findPath(lca, destValue, pathToDest);
        
        // Convert pathToStart to 'U's
        for (int i = 0; i < pathToStart.length(); i++) {
            pathToStart.setCharAt(i, 'U');
        }
        
        // Combine both paths
        return pathToStart.toString() + pathToDest.toString();
    }

    // Helper function to find the Lowest Common Ancestor (LCA) of two nodes
    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    // Helper function to find the path from the root to a target node
    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        // Search in the left subtree
        path.append('L');
        if (findPath(root.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        // Search in the right subtree
        path.append('R');
        if (findPath(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }
}