class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] < arr[mid + 1]) {
                // Peak is to the right
                left = mid + 1;
            } else {
                // Peak is to the left or at mid
                right = mid;
            }
        }
        
        // Left and right have converged to the peak index
        return left;
    }
}