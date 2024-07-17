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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for(int val:to_delete){
            toDeleteSet.add(val);
        }

        List<TreeNode> remainingRoots=new ArrayList<>();
        traverse(root,true,toDeleteSet,remainingRoots);
        return remainingRoots;
    }

    private TreeNode traverse(TreeNode node,boolean isRoot, Set<Integer> toDeleteSet, List<TreeNode> remainingRoots){
        if(node==null){ return null; }
        boolean rootDeleted = toDeleteSet.contains(node.val);
        if(isRoot && !rootDeleted){
            remainingRoots.add(node);
        }

        node.left = traverse(node.left, rootDeleted, toDeleteSet, remainingRoots);
        node.right = traverse(node.right, rootDeleted, toDeleteSet, remainingRoots);

        return rootDeleted ? null : node;
    }

}