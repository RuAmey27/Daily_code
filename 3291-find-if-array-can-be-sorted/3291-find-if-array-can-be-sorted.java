class Solution {
    public boolean canSortArray(int[] nums) {
         int n = nums.length;
        List<int[]> segments = new ArrayList<>();
        
        // Step 1: Split into segments based on consecutive elements with the same set bits count
        int start = 0;
        while (start < n) {
            int bitCount = Integer.bitCount(nums[start]);
            int end = start;
            while (end < n && Integer.bitCount(nums[end]) == bitCount) {
                end++;
            }
            segments.add(Arrays.copyOfRange(nums, start, end));
            start = end;
        }
        
        // Step 2: Sort each segment
        for (int[] segment : segments) {
            Arrays.sort(segment);
        }
        
        // Step 3: Check the sorted order across segments
        int prevMax = segments.get(0)[segments.get(0).length - 1];
        for (int i = 1; i < segments.size(); i++) {
            int[] segment = segments.get(i);
            int currentMin = segment[0];
            if (prevMax > currentMin) {
                return false;
            }
            prevMax = segment[segment.length - 1];
        }
        
        return true;
    }
}