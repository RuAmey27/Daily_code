class Solution {
    private static boolean canDistribute(int[] quantities, int n, int x) {
        int requiredStores = 0;
        for (int quantity : quantities) {
            // Calculate the number of stores needed for the current product type
            requiredStores += (quantity + x - 1) / x; // Equivalent to Math.ceil(quantity / x)
        }
        return requiredStores <= n;
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 0;
        for (int quantity : quantities) {
            right = Math.max(right, quantity); // Find the maximum quantity
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (canDistribute(quantities, n, mid)) {
                right = mid; // Try for a smaller x
            } else {
                left = mid + 1; // Increase x
            }
        }
        return left;
    }

}