class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        int[] counts = new int[]{a, b, c};
        char[] letters = new char[]{'a', 'b', 'c'};
        
        while (true) {
            // Sort the letters by their remaining counts (greedy choice for the most frequent letter)
            int first = 0, second = 1, third = 2;
            if (counts[first] < counts[second]) swap(counts, letters, first, second);
            if (counts[second] < counts[third]) swap(counts, letters, second, third);
            if (counts[first] < counts[second]) swap(counts, letters, first, second);
            
            // If we can't add the most frequent letter anymore, break
            if (counts[first] == 0) break;
            
            // Add the most frequent letter up to 2 times
            if (result.length() >= 2 && result.charAt(result.length() - 1) == letters[first] && result.charAt(result.length() - 2) == letters[first]) {
                if (counts[second] == 0) break;
                result.append(letters[second]);
                counts[second]--;
            } else {
                result.append(letters[first]);
                counts[first]--;
            }
        }
        
        return result.toString();
    }
    
    private void swap(int[] counts, char[] letters, int i, int j) {
        int tempCount = counts[i];
        counts[i] = counts[j];
        counts[j] = tempCount;
        
        char tempLetter = letters[i];
        letters[i] = letters[j];
        letters[j] = tempLetter;
    }
}
