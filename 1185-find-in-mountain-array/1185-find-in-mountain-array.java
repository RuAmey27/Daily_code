/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
    int n = mountainArr.length();
        
        // Step 1: Find the peak of the mountain array
        int peak = findPeakIndex(mountainArr, n);
        
        // Step 2: Binary search in the increasing part
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) {
            return index; // Found target in the increasing part
        }
        
        // Step 3: Binary search in the decreasing part
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }
    
    private int findPeakIndex(MountainArray mountainArr, int n) {
        int left = 0, right = n - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1; // Move to the increasing part
            } else {
                right = mid; // Move to the decreasing part
            }
        }
        
        return left; // Peak index
    }
    
    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean ascending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            }
            
            if (ascending) {
                if (midVal < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (midVal < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        return -1; // Target not found
    }
}