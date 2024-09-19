class Solution {
    public int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Iterate through the array.
        for (int num : nums) {
            // Add the current number to the heap.
            minHeap.add(num);
            
            // If the heap size exceeds k, remove the smallest element.
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The root of the min-heap is the k-th largest element.
        return minHeap.peek();
    }
}