class Solution {
    public int firstMissingPositive(int[] nums) {
       int n = nums.length;
        
        // Step 1: Partition the array so that all positive integers are at the front
        int i = 0;
        while (i < n) {
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        
        // Step 2: Find the first missing positive integer
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If all positive integers from 1 to n are present, the missing integer is n + 1
        return n + 1;
    }
}
