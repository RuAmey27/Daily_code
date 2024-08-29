class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        // Adjacency list to store connections between stones
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        boolean[] visited = new boolean[n];

        // Build adjacency lists for rows and columns
        for (int i = 0; i < n; i++) {
            int x = stones[i][0];
            int y = stones[i][1];

            // Map stones by row
            rowMap.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
            // Map stones by column
            colMap.computeIfAbsent(y, k -> new ArrayList<>()).add(i);
        }

        int numComponents = 0;

        // Perform DFS for each stone
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // New component found, explore it completely
                dfs(i, stones, visited, rowMap, colMap);
                numComponents++;
            }
        }

        // The maximum number of stones that can be removed
        return n - numComponents;
    }

    private void dfs(int index, int[][] stones, boolean[] visited, 
                     Map<Integer, List<Integer>> rowMap, Map<Integer, List<Integer>> colMap) {
        Stack<Integer> stack = new Stack<>();
        stack.push(index);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (visited[current]) continue;
            visited[current] = true;

            int x = stones[current][0];
            int y = stones[current][1];

            // Visit all stones in the same row
            for (int rowIndex : rowMap.get(x)) {
                if (!visited[rowIndex]) {
                    stack.push(rowIndex);
                }
            }

            // Visit all stones in the same column
            for (int colIndex : colMap.get(y)) {
                if (!visited[colIndex]) {
                    stack.push(colIndex);
                }
            }
        }
    }
}