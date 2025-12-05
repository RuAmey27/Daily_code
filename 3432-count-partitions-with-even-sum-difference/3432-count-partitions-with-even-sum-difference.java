class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0; // no valid split if fewer than 2 elements

        long total = 0;
        for (int x : nums) total += x;

        // If total is odd -> 0. If even -> every split (n-1) is valid.
        return (total % 2 == 0) ? (n - 1) : 0;
    }
}
