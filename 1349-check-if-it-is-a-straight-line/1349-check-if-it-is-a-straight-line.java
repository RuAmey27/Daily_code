class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        int dx = x1 - x0;
        int dy = y1 - y0;
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            
            
            int dx1 = x - x0;
            int dy1 = y - y0;
            
            
            if (dx * dy1 != dy * dx1) {
                return false;
            }
        }

        return true;


    }
}