# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def countPairs(self, root: TreeNode, distance: int) -> int:
        self.distance = distance
        self.result = 0
        
        def dfs(node):
            if not node:
                return []
            
            if not node.left and not node.right:
                return [1]  # Return a list with a single leaf depth
            
            left = dfs(node.left)
            right = dfs(node.right)
            
            # Check for valid pairs
            for l in left:
                for r in right:
                    if l + r <= self.distance:
                        self.result += 1
            
            # Propagate leaf depths upwards
            return [depth + 1 for depth in left + right if depth + 1 <= self.distance]
        
        dfs(root)
        return self.result
