class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> setallow = new HashSet<>();
        for (char a : allowed.toCharArray()) {
            setallow.add(a);
        }
        
        int count = 0;
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!setallow.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                count++;
            }
        }
        
        return count;
    }
}