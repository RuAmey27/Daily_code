class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result; // Early exit if the length is out of bounds
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<String> result) {
        // Base case: if we have 4 segments and we've used up all characters
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current)); // Join segments with dots and add to result
            }
            return;
        }

        // Iterate over the possible end positions for the current segment
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(start) == '0') {
                break; // Skip segments with leading zeros
            }

            String segment = s.substring(start, i + 1);
            if (Integer.parseInt(segment) > 255) {
                break; // Skip segments that are greater than 255
            }

            current.add(segment);
            backtrack(s, i + 1, current, result); // Recursively process the next segment
            current.remove(current.size() - 1); // Backtrack
        }
}
}