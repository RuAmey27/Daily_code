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
import java.util.*;

class Solution {
    Map<Integer, Integer> heights = new HashMap<>();
    Map<Integer, Integer> depths = new HashMap<>();
    Map<Integer, List<Integer>> depthToNodes = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        // Step 1: Calculate heights and depths
        computeHeightsAndDepths(root, 0);

        // Step 2: Track max and second max heights at each depth
        Map<Integer, Integer> maxAtDepth = new HashMap<>();
        Map<Integer, Integer> secondMaxAtDepth = new HashMap<>();
        
        for (int node : heights.keySet()) {
            int depth = depths.get(node);
            int height = heights.get(node);
            
            if (!maxAtDepth.containsKey(depth) || height > maxAtDepth.get(depth)) {
                secondMaxAtDepth.put(depth, maxAtDepth.getOrDefault(depth, -1));
                maxAtDepth.put(depth, height);
            } else if (!secondMaxAtDepth.containsKey(depth) || height > secondMaxAtDepth.get(depth)) {
                secondMaxAtDepth.put(depth, height);
            }
        }
        
        // Step 3: Answer each query
        int[] answer = new int[queries.length];
        int treeHeight = maxAtDepth.get(0);
        
        for (int i = 0; i < queries.length; i++) {
            int node = queries[i];
            int depth = depths.get(node);
            int height = heights.get(node);
            
            if (maxAtDepth.get(depth) == height) {
                answer[i] = treeHeight - height + secondMaxAtDepth.getOrDefault(depth, 0);
            } else {
                answer[i] = treeHeight;
            }
        }
        
        return answer;
    }

    private int computeHeightsAndDepths(TreeNode node, int depth) {
        if (node == null) return -1;
        
        depths.put(node.val, depth);
        int leftHeight = computeHeightsAndDepths(node.left, depth + 1);
        int rightHeight = computeHeightsAndDepths(node.right, depth + 1);
        
        int height = 1 + Math.max(leftHeight, rightHeight);
        heights.put(node.val, height);
        
        return height;
    }
}
