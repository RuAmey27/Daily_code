class Solution {
    public int firstUniqChar(String s) {
        int[] charCount = new int[26];  // Array for 'a' to 'z'
        
        // Count the occurrences of each character
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // Find the first character with a count of 1
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}