class Solution {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for the longest odd-length palindrome (single character center)
            int len1 = expandAroundCenter(s, i, i);
            // Check for the longest even-length palindrome (pair of characters center)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Get the maximum length
            int len = Math.max(len1, len2);
            
            // Update the start and end indices of the longest palindrome found so far
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}