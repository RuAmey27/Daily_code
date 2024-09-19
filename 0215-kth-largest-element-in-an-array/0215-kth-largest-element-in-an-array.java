class Solution {
    public int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Add all elements to the max-heap
        for (int num : nums) {
            maxHeap.add(num);
        }

        // Poll the max-heap k times to get the kth largest element
        int kthLargest = 0;
        for (int i = 0; i < k; i++) {
            kthLargest = maxHeap.poll();
        }

        return kthLargest;
    }
}