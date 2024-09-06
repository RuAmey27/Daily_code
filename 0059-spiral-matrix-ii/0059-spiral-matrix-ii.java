class Solution {
    public int[][] generateMatrix(int k) {
        
        int [][] matrix=new int[k][k];

        

        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int c=1;
        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top boundary
            for (int i = left; i <= right; i++) {
                matrix[top][i]=c;
                c++;
            }
            top++; // move the top boundary down

            // Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                matrix[i][right]=c;
                c++;
            }
            right--; // move the right boundary left

            // Traverse from right to left along the bottom boundary
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i]=c;
                    c++;
                }
                bottom--; // move the bottom boundary up
            }

            // Traverse from bottom to top along the left boundary
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left]=c;
                    c++;
                }
                left++; // move the left boundary right
            }
        }

        return matrix;
    }
}