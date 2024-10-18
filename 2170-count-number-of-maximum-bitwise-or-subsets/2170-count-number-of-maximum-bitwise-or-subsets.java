class Solution {
    public int countMaxOrSubsets(int[] nums) {
    int maxOr = 0;
        for (int num : nums) {
            maxOr |= num; // Find the maximum possible OR value
        }
        
        return countSubsets(nums, 0, 0, maxOr);
    }
    
    private int countSubsets(int[] nums, int index, int currentOr, int maxOr) {
        if (index == nums.length) {
            return currentOr == maxOr ? 1 : 0;
        }
        
        // Option 1: Include nums[index] in the subset
        int include = countSubsets(nums, index + 1, currentOr | nums[index], maxOr);
        
        // Option 2: Exclude nums[index] from the subset
        int exclude = countSubsets(nums, index + 1, currentOr, maxOr);
        
        return include + exclude;
    }
}