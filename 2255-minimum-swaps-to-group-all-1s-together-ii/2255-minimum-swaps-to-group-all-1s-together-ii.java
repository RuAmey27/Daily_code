class Solution {
    public int minSwaps(int[] nums) {
        int countOnes = 0;
        for (int num : nums) {
            if (num == 1) countOnes++;
        }
        
        if (countOnes == 0 || countOnes == nums.length) return 0; 
        
        int n = nums.length;
        int maxOnesInWindow = 0, currentOnesInWindow = 0;
        
        for (int i = 0; i < countOnes; i++) {
            currentOnesInWindow += nums[i];
        }
        maxOnesInWindow = currentOnesInWindow;
        
        for (int i = 1; i < n; i++) {
            currentOnesInWindow += nums[(i + countOnes - 1) % n] - nums[(i - 1) % n];
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnesInWindow);
        }
        
        return countOnes - maxOnesInWindow;
    }
}
