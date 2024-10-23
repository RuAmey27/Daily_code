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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;

        // BFS queue to traverse the tree level by level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // Root node must always be set to 0
        root.val = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;
            List<TreeNode> levelNodes = new ArrayList<>();
            
            // Calculate total sum of values at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node);
                
                // Add the children to the queue for the next level
                if (node.left != null) {
                    queue.offer(node.left);
                    levelSum += node.left.val;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    levelSum += node.right.val;
                }
            }
            
            // For each node in the level, calculate the cousin sum
            for (TreeNode node : levelNodes) {
                int cousinSum = levelSum; // Start with the total level sum

                // Subtract the sibling values
                if (node.left != null) {
                    cousinSum -= node.left.val;
                }
                if (node.right != null) {
                    cousinSum -= node.right.val;
                }

                // Assign the cousin sum to the child nodes
                if (node.left != null) {
                    node.left.val = cousinSum;
                }
                if (node.right != null) {
                    node.right.val = cousinSum;
                }
            }
        }

        return root;
    }
}
