class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
         int rows = rowSum.length;
        int cols = colSum.length;
        
        int[][] result = new int[rows][cols];
        
        // Iterate through each cell of the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Fill the cell with the minimum of remaining rowSum[i] and colSum[j]
                result[i][j] = Math.min(rowSum[i], colSum[j]);
                // Update rowSum[i] and colSum[j]
                rowSum[i] -= result[i][j];
                colSum[j] -= result[i][j];
            }
        }
        
        return result;
    }
}