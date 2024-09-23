class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remainderCount = new int[k]; // Array to count occurrences of remainders
        remainderCount[0] = 1; // Handle the case when cumulative sum is exactly divisible by k
        int cumSum = 0;
        int count = 0;

        for (int num : nums) {
            cumSum += num;
            int mod = ((cumSum % k) + k) % k; // Ensure non-negative modulo

            // Count the number of valid subarrays ending at the current index
            count += remainderCount[mod];

            // Update the count of this remainder
            remainderCount[mod]++;
        }

        return count;
    }
}