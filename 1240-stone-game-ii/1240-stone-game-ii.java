class Solution {
    public int stoneGameII(int[] piles) {
         int n = piles.length;
    int[][] dp = new int[n][n + 1];
    int[] suffixSum = new int[n];
    
    suffixSum[n-1] = piles[n-1];
    for (int i = n - 2; i >= 0; i--) {
        suffixSum[i] = suffixSum[i + 1] + piles[i];
    }
    
   
    for (int i = n - 1; i >= 0; i--) {
        for (int M = 1; M <= n; M++) {
            if (i + 2 * M >= n) {
                dp[i][M] = suffixSum[i]; 
            } else {
                int minOpponentStones = Integer.MAX_VALUE;
                for (int X = 1; X <= 2 * M; X++) {
                    minOpponentStones = Math.min(minOpponentStones, dp[i + X][Math.max(M, X)]);
                }
                dp[i][M] = suffixSum[i] - minOpponentStones;
            }
        }
    }
    
    return dp[0][1]; 
    }
}