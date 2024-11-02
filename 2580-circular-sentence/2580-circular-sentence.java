class Solution {
    public boolean isCircularSentence(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Iterate through each word and check the circular conditions
        for (int i = 0; i < words.length; i++) {
            // Get the last character of the current word
            char lastChar = words[i].charAt(words[i].length() - 1);
            // Get the first character of the next word (wrapping around to the first word for the last word)
            char firstChar = words[(i + 1) % words.length].charAt(0);
            
            // If the characters do not match, the sentence is not circular
            if (lastChar != firstChar) {
                return false;
            }
        }
        
        // If all characters match, the sentence is circular
        return true;
    }
}