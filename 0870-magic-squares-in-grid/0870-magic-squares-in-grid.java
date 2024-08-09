class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

     private boolean isMagicSquare(int[][] grid, int row, int col) {
        // Check if all numbers are distinct and within the range 1 to 9
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[row + i][col + j];
                if (val < 1 || val > 9 || seen[val]) {
                    return false;
                }
                seen[val] = true;
            }
        }

        // Check row sums, column sums, and diagonal sums
        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        
        // Check rows
        if (grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2] != sum ||
            grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2] != sum) {
            return false;
        }

        // Check columns
        if (grid[row][col] + grid[row + 1][col] + grid[row + 2][col] != sum ||
            grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1] != sum ||
            grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2] != sum) {
            return false;
        }

        // Check diagonals
        if (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != sum ||
            grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != sum) {
            return false;
        }

        return true;
    }
}