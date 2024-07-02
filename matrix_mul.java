class StrassenMatrixMultiplication {

    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;

        // Base case for recursive algorithm
        if (n == 1) {
            int[][] C = new int[1][1];
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }

        // Divide matrices into submatrices
        int[][] A11 = new int[n / 2][n / 2];
        int[][] A12 = new int[n / 2][n / 2];
        int[][] A21 = new int[n / 2][n / 2];
        int[][] A22 = new int[n / 2][n / 2];

        int[][] B11 = new int[n / 2][n / 2];
        int[][] B12 = new int[n / 2][n / 2];
        int[][] B21 = new int[n / 2][n / 2];
        int[][] B22 = new int[n / 2][n / 2];

        splitMatrix(A, A11, 0, 0);
        splitMatrix(A, A12, 0, n / 2);
        splitMatrix(A, A21, n / 2, 0);
        splitMatrix(A, A22, n / 2, n / 2);

        splitMatrix(B, B11, 0, 0);
        splitMatrix(B, B12, 0, n / 2);
        splitMatrix(B, B21, n / 2, 0);
        splitMatrix(B, B22, n / 2, n / 2);

        // Compute submatrices for Strassen's multiplication
        int[][] P1 = multiply(add(A11, A22), add(B11, B22));
        int[][] P2 = multiply(add(A21, A22), B11);
        int[][] P3 = multiply(A11, subtract(B12, B22));
        int[][] P4 = multiply(A22, subtract(B21, B11));
        int[][] P5 = multiply(add(A11, A12), B22);
        int[][] P6 = multiply(subtract(A21, A11), add(B11, B12));
        int[][] P7 = multiply(subtract(A12, A22), add(B21, B22));

        // Compute submatrices of result
        int[][] C11 = add(subtract(add(P1, P4), P5), P7);
        int[][] C12 = add(P3, P5);
        int[][] C21 = add(P2, P4);
        int[][] C22 = add(subtract(add(P1, P3), P2), P6);

        // Combine submatrices into result matrix
        int[][] C = new int[n][n];
        joinMatrix(C11, C, 0, 0);
        joinMatrix(C12, C, 0, n / 2);
        joinMatrix(C21, C, n / 2, 0);
        joinMatrix(C22, C, n / 2, n / 2);

        return C;
    }

    private static void splitMatrix(int[][] source, int[][] destination, int rowOffset, int colOffset) {
        for (int i = 0; i < destination.length; i++) {
            for (int j = 0; j < destination.length; j++) {
                destination[i][j] = source[i + rowOffset][j + colOffset];
            }
        }
    }

    private static void joinMatrix(int[][] source, int[][] destination, int rowOffset, int colOffset) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length; j++) {
                destination[i + rowOffset][j + colOffset] = source[i][j];
            }
        }
    }

    private static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    private static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] B = {{17, 18, 19, 20}, {21, 22, 23, 24}, {25, 26, 27, 28}, {29, 30, 31, 32}};

        System.out.println("Matrix A:");
        printMatrix(A);
        System.out.println("Matrix B:");
        printMatrix(B);

        int[][] result = multiply(A, B);

        System.out.println("Result of matrix multiplication:");
        printMatrix(result);
    }
}
