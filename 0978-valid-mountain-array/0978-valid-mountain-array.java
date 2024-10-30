class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        
        if (n < 3) return false; // A mountain array must have at least 3 elements
        
        int i = 0;

        // Climb up to the peak
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        
        // Peak can't be the first or last element
        if (i == 0 || i == n - 1) return false;
        
        // Climb down from the peak
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // Check if we've reached the end of the array
        return i == n - 1;
    }
}