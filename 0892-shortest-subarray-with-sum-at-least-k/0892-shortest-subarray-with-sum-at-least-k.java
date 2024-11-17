class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
    long[] prefixSum = new long[n + 1];
    
    // Calculate prefix sum
    for (int i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + nums[i];
    }

    int minLength = n + 1;
    Deque<Integer> deque = new LinkedList<>();
    
    for (int i = 0; i <= n; i++) {
        // Check if we have a valid subarray
        while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
            minLength = Math.min(minLength, i - deque.pollFirst());
        }
        
        // Maintain a deque in increasing order of prefix sums
        while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
            deque.pollLast();
        }
        
        deque.offerLast(i);
    }

    return minLength <= n ? minLength : -1;
    }
}