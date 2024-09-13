class Solution {
     public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        generateStrings(n, "", result);
        return result;
    }
    
    private void generateStrings(int n, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        
        generateStrings(n, current + "1", result);  // Add '1' in any position

        if (current.isEmpty() || current.charAt(current.length() - 1) != '0') {
            generateStrings(n, current + "0", result);  // Add '0' only if the previous char is not '0'
        }
    }
}