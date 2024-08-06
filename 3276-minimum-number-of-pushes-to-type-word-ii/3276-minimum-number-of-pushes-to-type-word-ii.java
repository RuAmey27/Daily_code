class Solution {
     public static int minimumPushes(String word) {
        // Step 1: Frequency count of each letter
        Map<Character, Integer> freq = new HashMap<>();
            for (char ch : word.toCharArray()) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            }

        // Step 2: Sort the letters by frequency in descending order
        List<Map.Entry<Character, Integer>> sortedLetters = new ArrayList<>(freq.entrySet());
        sortedLetters.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Step 3: Assign letters to keys and calculate key presses
        int keyPresses = 0;
        int position = 0;
        int numKeys = 8; // Number of keys available for mapping

        for (Map.Entry<Character, Integer> entry : sortedLetters) {
            // Calculate the number of key presses for each letter
            int pressesForLetter = (position / numKeys) + 1;
            keyPresses += pressesForLetter * entry.getValue();
            position++;
        }

        return keyPresses;
    }

}