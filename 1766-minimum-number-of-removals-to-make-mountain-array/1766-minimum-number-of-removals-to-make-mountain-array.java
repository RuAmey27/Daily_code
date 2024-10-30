class Solution {
    public int minimumMountainRemovals(int[] nums) {
    int n = nums.length;
    
    // Arrays to store LIS and LDS lengths
    int[] lis = new int[n];
    int[] lds = new int[n];
    
    // Calculate LIS for each index
    for (int i = 0; i < n; i++) {
        lis[i] = 1;
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
    }
    
    // Calculate LDS for each index
    for (int i = n - 1; i >= 0; i--) {
        lds[i] = 1;
        for (int j = i + 1; j < n; j++) {
            if (nums[i] > nums[j]) {
                lds[i] = Math.max(lds[i], lds[j] + 1);
            }
        }
    }
    
    // Find the longest mountain array length
    int maxMountainLength = 0;
    for (int i = 1; i < n - 1; i++) {
        if (lis[i] > 1 && lds[i] > 1) { // Valid peak
            maxMountainLength = Math.max(maxMountainLength, lis[i] + lds[i] - 1);
        }
    }
    
    // Minimum removals to make the mountain array
    return n - maxMountainLength;
}

}