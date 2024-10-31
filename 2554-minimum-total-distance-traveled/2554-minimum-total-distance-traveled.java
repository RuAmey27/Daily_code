class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
     // Sort robot positions and factory positions
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize memoization table
        Long[][] dp = new Long[robot.size()][factory.length];
        
        // Start recursive DP
        return dfs(robot, factory, 0, 0, dp);
    }

    private long dfs(List<Integer> robot, int[][] factory, int i, int j, Long[][] dp) {
        // If all robots are repaired, return 0
        if (i == robot.size()) {
            return 0;
        }
        // If no more factories left, return a large value (impossible case)
        if (j == factory.length) {
            return (long) 1e18; // Use 10^18 as the substitute for Long.MAX_VALUE
        }
        // If already computed, return the stored value
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Option 1: Skip current factory `j`
        long minDist = dfs(robot, factory, i, j + 1, dp);

        // Option 2: Use current factory `j`
        long currentDist = 0;
        for (int k = 0; k < factory[j][1] && i + k < robot.size(); k++) {
            // Calculate distance for assigning `k+1` robots to factory `j`
            currentDist += Math.abs(robot.get(i + k) - factory[j][0]);
            minDist = Math.min(minDist, currentDist + dfs(robot, factory, i + k + 1, j + 1, dp));
        }

        // Memoize and return result
        return dp[i][j] = minDist;
    }
}