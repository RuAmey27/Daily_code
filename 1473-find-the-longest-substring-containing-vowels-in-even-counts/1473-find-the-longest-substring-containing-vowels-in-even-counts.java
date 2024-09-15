class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[32]; // to store the first occurrence of each bitmask
        Arrays.fill(pos, -1);
        int mask = 0, result = 0;
        pos[0] = 0; // initial state when no vowels have been seen

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // Update the mask based on the current character
            if (ch == 'a') mask ^= (1 << 0);
            if (ch == 'e') mask ^= (1 << 1);
            if (ch == 'i') mask ^= (1 << 2);
            if (ch == 'o') mask ^= (1 << 3);
            if (ch == 'u') mask ^= (1 << 4);

            // Check if this bitmask has been seen before
            if (pos[mask] >= 0) {
                result = Math.max(result, i + 1 - pos[mask]);
            } else {
                pos[mask] = i + 1;
            }
        }

        return result;
    }
}