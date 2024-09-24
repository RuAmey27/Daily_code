class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> arr1Prefixes = new HashSet<>();
        
        for (int val : arr1) {
            while (val > 0) {
                arr1Prefixes.add(val);
                val /= 10;
            }
        }

        int longestPrefix = 0;

        for (int val : arr2) {
            while (val > 0) {
                if (arr1Prefixes.contains(val)) {
                    longestPrefix = Math.max(longestPrefix, (int) Math.log10(val) + 1);
                    break;
                }
                val /= 10;
            }
        }

        return longestPrefix;
    }
}