class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int col1 = coordinate1.charAt(0) - 'a';
        int row1 = coordinate1.charAt(1) - '1';

        int col2 = coordinate2.charAt(0) - 'a';
        int row2 = coordinate2.charAt(1) - '1';

        // Check if both squares are of the same color
        // If the sum of col and row is even for both, they are black; if odd for both, they are white
        return (col1 + row1) % 2 == (col2 + row2) % 2;   
    }
}