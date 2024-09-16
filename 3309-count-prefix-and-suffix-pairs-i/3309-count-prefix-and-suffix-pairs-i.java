class Solution {
    
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        int n = words.length;

        // Iterate over all pairs (i, j) where i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check if words[i] is both prefix and suffix of words[j]
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    // Helper function to check if str1 is both prefix and suffix of str2
    private static boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}