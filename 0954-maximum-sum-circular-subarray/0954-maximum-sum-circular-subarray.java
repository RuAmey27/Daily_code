class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0], currentMax = nums[0];
        int minSum = nums[0], currentMin = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);
            
            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);
            
            totalSum += nums[i];
        }
        totalSum += nums[0];  // Add the first element to totalSum
        
        // If all elements are negative, maxSum would be the largest negative number.
        if (maxSum < 0) {
            return maxSum;
        }
        
        return Math.max(maxSum, totalSum - minSum);
    }
}