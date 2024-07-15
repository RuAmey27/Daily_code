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
    public TreeNode createBinaryTree(int[][] descriptions) {
      Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;

            TreeNode parent = nodes.computeIfAbsent(parentVal, k -> new TreeNode(k));
            TreeNode child = nodes.computeIfAbsent(childVal, k -> new TreeNode(k));

            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            children.add(childVal);
        }

        TreeNode root = null;
        for (int key : nodes.keySet()) {
            if (!children.contains(key)) {
                root = nodes.get(key);
                break;
            }
        }

        return root;
    }  
    
}