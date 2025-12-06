class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int MOD = 1000000007;
        
        // dp[i] = number of valid partitions for first i elements
        long[] dp = new long[n + 1];
        dp[0] = 1; // empty array has 1 partition
        
        // prefix sum of dp for efficient range sum queries
        long[] prefix = new long[n + 2];
        prefix[1] = 1; // prefix[1] = dp[0]
        
        // Deques for maintaining max and min in current window
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        int left = 0; // left boundary of valid window
        
        for (int right = 0; right < n; right++) {
            // Maintain max deque (decreasing)
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);
            
            // Maintain min deque (increasing)
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);
            
            // Shrink window from left if current window is invalid
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && 
                   nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > k) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }
            
            // Now window [left, right] is valid
            // All segments ending at right starting from left to right are valid
            // dp[right+1] = sum(dp[left] to dp[right])
            
            if (left <= right) {
                // sum from dp[left] to dp[right]
                // prefix[right+1] - prefix[left]
                long sum = (prefix[right + 1] - prefix[left] + MOD) % MOD;
                dp[right + 1] = sum;
                prefix[right + 2] = (prefix[right + 1] + dp[right + 1]) % MOD;
            }
        }
        
        return (int)(dp[n] % MOD);
    }
}