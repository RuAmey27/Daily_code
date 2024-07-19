class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> luckyNumbers = new ArrayList<>();

        // Step 1: Find the minimum elements in each row
        int[] minInRow = new int[m];
        for (int i = 0; i < m; i++) {
            int min = matrix[i][0];
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            minInRow[i] = min;
        }

        // Step 2: Check if these minimum elements are the maximum in their columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minInRow[i]) {
                    boolean isMaxInColumn = true;
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][j] > matrix[i][j]) {
                            isMaxInColumn = false;
                            break;
                        }
                    }
                    if (isMaxInColumn) {
                        luckyNumbers.add(matrix[i][j]);
                    }
                }
            }
        }

        return luckyNumbers;
    }
}