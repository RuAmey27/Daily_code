class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
    Arrays.sort(nums); // Sort the array to use two-pointer technique
        long count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Use two-pointer technique to find valid ranges
            int left = binarySearch(nums, lower - nums[i], i + 1, true);
            int right = binarySearch(nums, upper - nums[i], i + 1, false);
            
            count += (right - left + 1);
        }
        
        return count;
    }

    // Custom binary search to find the left and right boundaries
    private int binarySearch(int[] nums, int target, int start, boolean findLeft) {
        int left = start, right = nums.length - 1, result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((findLeft && nums[mid] >= target) || (!findLeft && nums[mid] <= target)) {
                result = mid;
                if (findLeft) right = mid - 1;
                else left = mid + 1;
            } else {
                if (findLeft) left = mid + 1;
                else right = mid - 1;
            }
        }
        
        return findLeft ? (result != -1 ? result : nums.length) : (result != -1 ? result : start - 1);
    }
}