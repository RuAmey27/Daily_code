class Solution {

    public int largestMagicSquare(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // 1x1 is always a magic square
        int maxSize = 1;

        // Try square sizes from largest to smallest
        for (int k = Math.min(m, n); k >= 2; k--) {

            // Top-left corner of k x k square
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {

                    if (isMagic(grid, i, j, k)) {
                        return k; // largest found
                    }
                }
            }
        }

        return maxSize;
    }

    // Check if k x k square starting at (r, c) is magic
    private boolean isMagic(int[][] grid, int r, int c, int k) {

        // Step 1: Reference sum (first row)
        int targetSum = 0;
        for (int j = c; j < c + k; j++) {
            targetSum += grid[r][j];
        }

        // Step 2: Check all rows
        for (int i = r; i < r + k; i++) {
            int rowSum = 0;
            for (int j = c; j < c + k; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum != targetSum) return false;
        }

        // Step 3: Check all columns
        for (int j = c; j < c + k; j++) {
            int colSum = 0;
            for (int i = r; i < r + k; i++) {
                colSum += grid[i][j];
            }
            if (colSum != targetSum) return false;
        }

        // Step 4: Main diagonal (↘)
        int diag1 = 0;
        for (int i = 0; i < k; i++) {
            diag1 += grid[r + i][c + i];
        }
        if (diag1 != targetSum) return false;

        // Step 5: Anti-diagonal (↙)
        int diag2 = 0;
        for (int i = 0; i < k; i++) {
            diag2 += grid[r + i][c + k - 1 - i];
        }
        if (diag2 != targetSum) return false;

        return true; // All conditions satisfied
    }
}
