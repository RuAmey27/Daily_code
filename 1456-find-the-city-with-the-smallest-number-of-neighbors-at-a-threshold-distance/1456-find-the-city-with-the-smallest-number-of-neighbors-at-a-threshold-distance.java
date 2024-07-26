class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
      
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE / 2); 
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
       
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            dist[from][to] = weight;
            dist[to][from] = weight;
        }
        
    
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
       
        int reacheable = n;
        int resultCity = -1;
        
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            
            if (reachableCities < reacheable || (reachableCities == reacheable && i > resultCity)) {
                reacheable = reachableCities;
                resultCity = i;
            }
        }
        
        return resultCity;

    }
}