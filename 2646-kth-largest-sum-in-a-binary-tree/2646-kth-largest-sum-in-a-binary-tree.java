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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<Long> levelSums = new ArrayList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            levelSums.add(levelSum);
        }
        
        if (levelSums.size() < k) return -1;
        
        // Sort level sums in descending order
        Collections.sort(levelSums, Collections.reverseOrder());
        
        return levelSums.get(k - 1);
    }
}