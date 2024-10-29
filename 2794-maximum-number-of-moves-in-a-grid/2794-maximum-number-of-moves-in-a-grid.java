public class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxMoves = 0;
        
        // Memoization array to store the max moves from each cell
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);  // initialize memo with -1 (unvisited)
        }
        
        // Start DFS from every cell in the first column and get the max moves
        for (int i = 0; i < m; i++) {
            maxMoves = Math.max(maxMoves, dfs(grid, i, 0, memo));
        }
        
        return maxMoves;
    }
    
    private int dfs(int[][] grid, int row, int col, int[][] memo) {
        int m = grid.length, n = grid[0].length;
        
        // If out of bounds or reached the last column, return 0
        if (col == n - 1) {
            return 0;
        }
        
        // Check if already computed
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        
        int maxMoves = 0;
        
        // Define possible moves
        int[][] directions = {{-1, 1}, {0, 1}, {1, 1}};
        
        // Explore each move direction
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            // Check bounds and value condition
            if (newRow >= 0 && newRow < m && newCol < n && grid[newRow][newCol] > grid[row][col]) {
                maxMoves = Math.max(maxMoves, 1 + dfs(grid, newRow, newCol, memo));
            }
        }
        
        // Memoize the result for current cell
        memo[row][col] = maxMoves;
        return maxMoves;
    }
}
