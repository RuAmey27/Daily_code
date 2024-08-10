class Solution {
    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
    public int regionsBySlashes(String[] grid) {
      int n = grid.length;
        int size = 4 * n * n;
        UnionFind uf = new UnionFind(size);

        for (int r = 0; r < n; ++r) {
            for (int c = 0; c < n; ++c) {
                int base = 4 * (r * n + c);
                char val = grid[r].charAt(c);

                // Connect internal edges of each cell
                if (val == '/') {
                    uf.union(base + 0, base + 3); // top with left
                    uf.union(base + 1, base + 2); // right with bottom
                } else if (val == '\\') {
                    uf.union(base + 0, base + 1); // top with right
                    uf.union(base + 2, base + 3); // bottom with left
                } else {
                    uf.union(base + 0, base + 1); // top with right
                    uf.union(base + 1, base + 2); // right with bottom
                    uf.union(base + 2, base + 3); // bottom with left
                }

                // Connect to the neighboring cells
                if (r + 1 < n) {
                    uf.union(base + 2, base + 4 * n + 0); // bottom with top of the cell below
                }
                if (c + 1 < n) {
                    uf.union(base + 1, base + 4 + 3); // right with left of the cell to the right
                }
            }
             }

        // Count the number of distinct regions
        int regions = 0;
        for (int i = 0; i < size; ++i) {
            if (uf.find(i) == i) {
                regions++;
            }
        }
        return regions;  
    }
}