class Solution {
    public int minOperations(int[] nums) {
         int operations = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int increment = nums[i - 1] + 1 - nums[i];
                operations += increment;
                nums[i] += increment;
            }
        }
        
        return operations;
    }
}