
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Step 1: Create a graph representation
        List<Map<Integer, Double>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashMap<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            double prob = succProb[i];
            graph.get(a).put(b, prob);
            graph.get(b).put(a, prob);
        }

        // Step 2: Priority queue for Dijkstra's algorithm, using a max-heap (Java's priority queue is a min-heap, so we negate the probability)
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        maxHeap.add(new double[]{1.0, start_node});

        // Step 3: Probability array to store the maximum probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        // Step 4: Implement Dijkstra's algorithm
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            double currentProb = current[0];
            int currentNode = (int) current[1];

            if (currentNode == end_node) {
                return currentProb;
            }

            for (Map.Entry<Integer, Double> neighbor : graph.get(currentNode).entrySet()) {
                int nextNode = neighbor.getKey();
                double edgeProb = neighbor.getValue();
                double newProb = currentProb * edgeProb;

                if (newProb > maxProb[nextNode]) {
                    maxProb[nextNode] = newProb;
                    maxHeap.add(new double[]{newProb, nextNode});
                }
            }
        }

        return 0.0;
    }
}
