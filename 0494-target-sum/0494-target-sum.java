class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return countWays(nums, 0, target, new HashMap<>());
    }

    private int countWays(int[] nums, int index, int currentSum, HashMap<String, Integer> memo) {
        if (index == nums.length) {
            return currentSum == 0 ? 1 : 0;
        }

        String key = index + "," + currentSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = countWays(nums, index + 1, currentSum - nums[index], memo);
        int subtract = countWays(nums, index + 1, currentSum + nums[index], memo);

        memo.put(key, add + subtract);
        
        
        return add + subtract;
    }
}