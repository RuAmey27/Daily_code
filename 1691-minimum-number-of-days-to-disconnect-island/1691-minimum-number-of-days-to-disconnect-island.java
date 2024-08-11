class Solution {
   public int minDays(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    // Step 1: Check if the grid is already disconnected
    if (countIslands(grid) != 1) {
        return 0; // Already disconnected
    }

    // Step 2: Check if removing any single land cell disconnects the grid
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == 1) {
                grid[i][j] = 0; // Remove the land cell
                if (countIslands(grid) != 1) {
                    return 1; // Disconnected by removing this cell
                }
                grid[i][j] = 1; // Restore the cell
            }
        }
    }

    // Step 3: If no single removal works, return 2
    return 2;
}

// Helper method to count the number of islands in the grid
private int countIslands(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];
    int islandCount = 0;

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                dfs(grid, visited, i, j);
                islandCount++;
                if (islandCount > 1) {
                    return islandCount; // No need to count further if more than 1 island is found
                }
            }
        }
    }

    return islandCount;
}

// Helper method to perform DFS to mark all connected land cells
private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
    int rows = grid.length;
    int cols = grid[0].length;

    if (i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j] || grid[i][j] == 0) {
        return; // Out of bounds or already visited or water cell
    }

    visited[i][j] = true;

    // Explore all four possible directions
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int[] dir : directions) {
        dfs(grid, visited, i + dir[0], j + dir[1]);
    }
}

}