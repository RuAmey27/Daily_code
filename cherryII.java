class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][][] dp = new int[rows][cols][cols];
        
        // Initialize dp array
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        
        dp[0][0][cols - 1] = grid[0][0] + grid[0][cols - 1];
        
        // Dynamic programming to fill the dp array
        for (int i = 1; i < rows; i++) {
            for (int j1 = 0; j1 < cols; j1++) {
                for (int j2 = 0; j2 < cols; j2++) {
                    for (int k1 = j1 - 1; k1 <= j1 + 1; k1++) {
                        for (int k2 = j2 - 1; k2 <= j2 + 1; k2++) {
                            if (k1 >= 0 && k1 < cols && k2 >= 0 && k2 < cols) {
                                int cherries = grid[i][j1];
                                if (j1 != j2) cherries += grid[i][j2];
                                dp[i][j1][j2] = Math.max(dp[i][j1][j2], dp[i - 1][k1][k2] + cherries);
                            }
                        }
                    }
                }
            }
        }
        
        int maxCherries = 0;
        for (int j1 = 0; j1 < cols; j1++) {
            for (int j2 = 0; j2 < cols; j2++) {
                maxCherries = Math.max(maxCherries, dp[rows - 1][j1][j2]);
            }
        }
        
        return maxCherries;
    }
}
