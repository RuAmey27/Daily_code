class Solution {
    public String sortVowels(String s) {
        // Step 1: Collect vowels
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        
        // Step 2: Sort vowels by ASCII
        Collections.sort(vowels);
        
        // Step 3: Build result string
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                result.append(vowels.get(vowelIndex++)); // replace from sorted vowels
            } else {
                result.append(c); // consonant stays same
            }
        }
        
        return result.toString();
    }
    
    // Utility: check if character is vowel
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
