class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0; // A mountain requires at least 3 elements
        
        int longest = 0;

        for (int i = 1; i < n - 1; i++) {
            // Check if arr[i] is a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;
                
                // Expand to the left
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }
                
                // Expand to the right
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                
                // Calculate the length of the mountain subarray
                int currentMountainLength = right - left + 1;
                longest = Math.max(longest, currentMountainLength);
                
                // Move i to the end of the current mountain
                i = right;
            }
        }

        return longest;
    }
}