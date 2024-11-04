class Solution {
    public String compressedString(String word) {
    StringBuilder comp = new StringBuilder(); // To build the compressed result
    int i = 0; // Pointer to iterate over the word

    while (i < word.length()) {
        char c = word.charAt(i); // Current character
        int count = 0; // Count occurrences of the current character, up to a max of 9

        // Count up to 9 consecutive occurrences of the same character
        while (i < word.length() && word.charAt(i) == c && count < 9) {
            count++;
            i++;
        }

        // Append the count followed by the character to the compressed string
        comp.append(count).append(c);
    }

    return comp.toString(); // Return the final compressed string
}

}