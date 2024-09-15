class Solution {
    public int findTheLongestSubstring(String s) {
        Map<String, Integer> stateMap = new HashMap<>();
        int[] vowelCount = new int[5]; // for 'a', 'e', 'i', 'o', 'u'
        String currentState = "00000"; // All vowels initially have even counts
        stateMap.put(currentState, -1); // Base case: state before any character is at index -1
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Update the vowel count based on the current character
            if (ch == 'a') vowelCount[0] ^= 1; // Toggle between even (0) and odd (1)
            else if (ch == 'e') vowelCount[1] ^= 1;
            else if (ch == 'i') vowelCount[2] ^= 1;
            else if (ch == 'o') vowelCount[3] ^= 1;
            else if (ch == 'u') vowelCount[4] ^= 1;

            // Convert the current vowel counts to a string representation (e.g., "01001")
            currentState = toStateString(vowelCount);

            // Check if this state has been seen before
            if (stateMap.containsKey(currentState)) {
                maxLength = Math.max(maxLength, i - stateMap.get(currentState));
            } else {
                stateMap.put(currentState, i); // Store the first occurrence of this state
            }
        }

        return maxLength;
    }

    // Helper function to convert vowel counts into a binary string like "01010"
    private String toStateString(int[] vowelCount) {
        StringBuilder sb = new StringBuilder();
        for (int count : vowelCount) {
            sb.append(count);
        }
        return sb.toString();
    }
}