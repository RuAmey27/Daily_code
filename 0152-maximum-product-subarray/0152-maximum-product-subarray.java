class Solution {
    public int maxProduct(int[] nums) {
    int max = nums[0];
    int cMax = nums[0];
    int cMin = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] < 0) {
            int temp = cMax;
            cMax = cMin;
            cMin = temp;
        }
        
        cMax = Math.max(nums[i], cMax * nums[i]);
        cMin = Math.min(nums[i], cMin * nums[i]);
        max = Math.max(max, cMax);
    }
    
    return max;
    }
}