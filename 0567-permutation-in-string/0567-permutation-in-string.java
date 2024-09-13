class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Lengths of the strings
        int len1 = s1.length();
        int len2 = s2.length();

        // If s1 is longer than s2, s1's permutation can't be in s2
        if (len1 > len2) {
            return false;
        }

        // Frequency arrays for s1 and the current window in s2
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Fill frequency array for s1
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        // Initial window in s2
        for (int i = 0; i < len1; i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // Check if initial window matches
        if (Arrays.equals(count1, count2)) {
            return true;
        }

        // Slide the window across s2
        for (int i = len1; i < len2; i++) {
            // Add the new character in the window
            count2[s2.charAt(i) - 'a']++;
            // Remove the old character from the window
            count2[s2.charAt(i - len1) - 'a']--;
            
            // Check if the updated window matches
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }
}