class Solution {
    public int minChanges(String s) {
        int changes = 0;

    // Process the string in blocks of 2
    for (int i = 0; i < s.length(); i += 2) {
        char first = s.charAt(i);
        char second = s.charAt(i + 1);

        // Check if the two characters in the block are different
        if (first != second) {
            changes++; // 1 change needed to make them the same
        }
        // No changes needed if the block is already "00" or "11"
    }

    return changes;
    }
}