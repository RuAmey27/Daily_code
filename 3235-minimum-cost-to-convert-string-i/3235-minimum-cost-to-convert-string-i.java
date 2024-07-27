class Solution {
  public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
    long[][] costs = new long[26][26];
    for (long[] row : costs) {
      Arrays.fill(row, Long.MAX_VALUE);
    }
    for (int i = 0; i < original.length; i++) {
      costs[original[i] - 'a'][changed[i] - 'a'] = Math.min(costs[original[i] - 'a'][changed[i] - 'a'], cost[i]);
    }
    floydWarshall(costs);

    long result = 0;
    char[] s = source.toCharArray();
    char[] t = target.toCharArray();
    for (int i = 0; i < s.length; i++) {
      int from = s[i] - 'a';
      int to = t[i] - 'a';
      long c = from != to ? costs[from][to] : 0L;
      if (c == Long.MAX_VALUE) {
        return -1;
      }
      result += c;
    }
    return result;
  }

  private void floydWarshall(long[][] costs) {
    for (int k = 0; k < 26; k++) {
      for (int i = 0; i < 26; i++) {
        for (int j = 0; j < 26; j++) {
          if (costs[i][k] != Long.MAX_VALUE && costs[k][j] != Long.MAX_VALUE) {
            costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
          }
        }
      }
    }
  }
}
