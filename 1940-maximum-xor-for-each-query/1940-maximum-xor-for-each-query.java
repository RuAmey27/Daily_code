class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
    int[] answer = new int[n];
    int xorValue = 0;

    // Step 1: Compute the XOR of the entire array
    for (int num : nums) {
        xorValue ^= num;
    }

    // Step 2: Process each query
    int maxK = (1 << maximumBit) - 1; // maxK is 2^maximumBit - 1
    for (int i = 0; i < n; i++) {
        // To maximize XOR, choose k = maxK XOR xorValue
        answer[i] = xorValue ^ maxK;
        // Remove the last element from the current nums array (equivalent)
        xorValue ^= nums[n - 1 - i];
    }

    return answer;
    }
}