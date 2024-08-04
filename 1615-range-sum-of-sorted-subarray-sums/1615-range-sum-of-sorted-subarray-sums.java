class Solution {
  
    private static final int MOD = 1_000_000_007;

    public int rangeSum(int[] nums, int n, int left, int right) {
       List<Long> subarraySums = new ArrayList<>();
        

        for (int start = 0; start < n; start++) {
            long currentSum = 0;
            for (int end = start; end < n; end++) {
                currentSum += nums[end];
                subarraySums.add(currentSum);
            }
        }

        Collections.sort(subarraySums);

        long sum = 0;
        for (int i = left - 1; i < right; i++) {
            sum = (sum + subarraySums.get(i)) % MOD;
        }

        return (int) sum;
    }
}