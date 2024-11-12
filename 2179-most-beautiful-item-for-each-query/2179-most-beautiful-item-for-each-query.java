class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
    int[][] queriesWithIndex = new int[queries.length][2];
    for (int i = 0; i < queries.length; i++) {
        queriesWithIndex[i][0] = queries[i];
        queriesWithIndex[i][1] = i;
    }
    Arrays.sort(queriesWithIndex, (a, b) -> a[0] - b[0]);
    
    int[] result = new int[queries.length];
    int maxBeauty = 0;
    int itemIndex = 0;
    
    for (int[] query : queriesWithIndex) {
        int queryPrice = query[0];
        int queryIndex = query[1];
        while (itemIndex < items.length && items[itemIndex][0] <= queryPrice) {
            maxBeauty = Math.max(maxBeauty, items[itemIndex][1]);
            itemIndex++;
        }
        result[queryIndex] = maxBeauty;
    }
    
    return result;
    }
}