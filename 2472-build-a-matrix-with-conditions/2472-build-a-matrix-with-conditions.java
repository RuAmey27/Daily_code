class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);

        if (rowOrder.size() != k || colOrder.size() != k) {
            return new int[0][0]; // No valid order exists
        }

        // Create position mappings
        Map<Integer, Integer> rowPos = new HashMap<>();
        Map<Integer, Integer> colPos = new HashMap<>();
        for (int i = 0; i < k; i++) {
            rowPos.put(rowOrder.get(i), i);
            colPos.put(colOrder.get(i), i);
        }

        // Initialize the k x k matrix with 0s
        int[][] matrix = new int[k][k];

        // Place the numbers in the matrix based on row and column positions
        for (int num = 1; num <= k; num++) {
            int r = rowPos.get(num);
            int c = colPos.get(num);
            matrix[r][c] = num;
        }

        return matrix;
    }

    private List<Integer> topologicalSort(int numNodes, int[][] edges) {
        // Build the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numNodes + 1];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
            inDegree[v]++;
        }

        // Topological sort
        Queue<Integer> zeroInDegree = new LinkedList<>();
        for (int i = 1; i <= numNodes; i++) {
            if (inDegree[i] == 0) {
                zeroInDegree.add(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!zeroInDegree.isEmpty()) {
            int node = zeroInDegree.poll();
            topoOrder.add(node);

            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        zeroInDegree.add(neighbor);
                    }
                }
            }
        }

        return topoOrder;
    }

}