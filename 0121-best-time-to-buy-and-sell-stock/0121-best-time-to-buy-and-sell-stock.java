class Solution {
    public int maxProfit(int[] prices) {
    int Profit = 0;
    int minval = Integer.MAX_VALUE;

    for (int val : prices) {
        if (val < minval) {
            minval = val;
        } else if (val - minval > Profit) {
            Profit = val - minval;
        }
    }

    return Profit;
    }
}