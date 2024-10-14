class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        long score = 0;

        // Add all elements to the max heap
        for (int num : nums) {
            maxHeap.add(num);
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            int maxElement = maxHeap.poll();  // Get the largest element
            score += maxElement;              // Add to the score
            int newElement = (int) Math.ceil(maxElement / 3.0);  // Replace with ceil(maxElement / 3)
            maxHeap.add(newElement);          // Add the modified element back to the heap
        }

        return score;
    }
}