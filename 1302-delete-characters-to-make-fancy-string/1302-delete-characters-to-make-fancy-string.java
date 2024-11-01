class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
    int consecutiveCount = 1;  // To count consecutive characters
    
    result.append(s.charAt(0)); // Start by adding the first character
    
    for (int i = 1; i < s.length(); i++) {
        // Check if the current character is the same as the previous one
        if (s.charAt(i) == s.charAt(i - 1)) {
            consecutiveCount++;
        } else {
            consecutiveCount = 1; // Reset the count if the characters are different
        }
        
        // Append the character only if there are fewer than 3 consecutive characters
        if (consecutiveCount < 3) {
            result.append(s.charAt(i));
        }
    }
    
    return result.toString();
    }
}