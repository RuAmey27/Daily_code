class Solution {
    public long minimumSteps(String s) {
    long zeroCount = 0;  // Count of white balls ('0') encountered so far
        long swaps = 0;      // Total number of swaps required
        
        // Traverse the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                // Increment the count of white balls encountered
                zeroCount++;
            } else {
                // For every black ball ('1'), add the count of white balls to the result
                swaps += zeroCount;
            }
        }
        
        return swaps;
    }
}