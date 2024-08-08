class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        int[][] result = new int[rows * cols][2];
        int step = 0; 
        int d = 0; 
        
        int r = rStart, c = cStart; 
        
        result[step++] = new int[]{r, c}; 
        
        for (int k = 1; step < rows * cols; k++) {
            for (int i = 0; i < 2; i++) { 
                for (int j = 0; j < k; j++) { 
                    r += dr[d];
                    c += dc[d];
                    
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[step++] = new int[]{r, c};
                    }
                }
                d = (d + 1) % 4;
            }
        }
        
        return result;
    }
}