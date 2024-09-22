class Solution {
   public int findKthNumber(int n, int k) {
        int curr = 1;  // Start from 1
        k--;  // Since we consider '1' as the first element
        
        while (k > 0) {
            int count = getCount(curr, n);  // Count the numbers in the subtree rooted at curr
            
            if (count <= k) {
                // Move to the next sibling
                curr++;
                k -= count;
            } else {
                // Move down to the next level (deeper in the current subtree)
                curr *= 10;
                k--;
            }
        }
        
        return curr;
    }
    
    private int getCount(int curr, int n) {
        long next = curr + 1;
        long count = 0;
        long current = curr;
        
        while (current <= n) {
            count += Math.min(n + 1, next) - current;  // Add the number of elements in this range
            current *= 10;
            next *= 10;
        }
        
        return (int) count;
    }
}