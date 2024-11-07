class Solution {
    public int largestCombination(int[] candidates) {
        int maxBitLength = 24;
        int maxSize = 0;
        
        // Iterate over each bit position
        for (int bit = 0; bit < maxBitLength; bit++) {
            int count = 0;
            for (int num : candidates) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }
            maxSize = Math.max(maxSize, count);
        }
        
        return maxSize;
    }
}