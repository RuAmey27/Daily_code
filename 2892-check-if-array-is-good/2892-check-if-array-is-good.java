class Solution {
    public boolean isGood(int[] nums) {
        // Step 1: find maximum element
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        // Step 2: check length
        if (nums.length != maxVal + 1) {
            return false;
        }
        
        // Step 3: count frequencies
        int[] count = new int[maxVal + 1]; // 1-based indexing
        for (int num : nums) {
            if (num < 1 || num > maxVal) return false;
            count[num]++;
        }
        
        // Step 4: validate counts
        for (int i = 1; i < maxVal; i++) {
            if (count[i] != 1) return false;
        }
        if (count[maxVal] != 2) return false;
        
        return true;
    }
}