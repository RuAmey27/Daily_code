class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            boolean isValid = true;
            int maxElement = nums[i];
            
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j + 1] != nums[j] + 1) {
                    isValid = false;
                    break;
                }
                maxElement = Math.max(maxElement, nums[j + 1]);
            }
            
            results[i] = isValid ? maxElement : -1;
        }
        
        return results;
    }
}