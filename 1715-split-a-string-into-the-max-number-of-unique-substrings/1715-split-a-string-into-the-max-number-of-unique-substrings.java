class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, Set<String> seen) {
        if (start == s.length()) {
            return 0;
        }
        
        int maxSplits = 0;
        for (int i = start + 1; i <= s.length(); i++) {
            String current = s.substring(start, i);
            if (!seen.contains(current)) {
                seen.add(current);
                maxSplits = Math.max(maxSplits, 1 + backtrack(s, i, seen));
                seen.remove(current);
            }
        }
        
        return maxSplits;
    }
}
