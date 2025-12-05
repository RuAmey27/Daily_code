class Solution {
    private List<Integer>[] graph;
    private int[] values;
    private int k;
    private int count;
    
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Initialize
        this.values = values;
        this.k = k;
        this.count = 0;
        
        // Build adjacency list
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        // Start DFS from node 0 (root)
        dfs(0, -1);
        
        return count;
    }
    
    private long dfs(int node, int parent) {
        long subtreeSum = values[node];
        
        // Process all neighbors except parent
        for (int neighbor : graph[node]) {
            if (neighbor == parent) continue;
            
            long childSum = dfs(neighbor, node);
            subtreeSum += childSum;
        }
        
        // If subtree sum is divisible by k, we can cut this subtree
        // (except for the root, which we handle specially)
        if (subtreeSum % k == 0) {
            count++;
            return 0; // Return 0 because we're cutting this subtree
        }
        
        return subtreeSum % k; // Return remainder
    }
}