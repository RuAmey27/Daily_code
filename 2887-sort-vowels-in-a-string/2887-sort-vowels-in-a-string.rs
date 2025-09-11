impl Solution {
    pub fn sort_vowels(s: String) -> String {
        // Step 1: Collect vowels
        let chars: Vec<char> = s.chars().collect();
        let mut vowels: Vec<char> = chars
            .iter()
            .cloned()
            .filter(|&c| Self::is_vowel(c))
            .collect();
        
        // Step 2: Sort vowels by ASCII
        vowels.sort_unstable();
        
        // Step 3: Build result string
        let mut result = String::with_capacity(s.len());
        let mut vowel_index = 0;
        
        for &c in &chars {
            if Self::is_vowel(c) {
                result.push(vowels[vowel_index]);
                vowel_index += 1;
            } else {
                result.push(c);
            }
        }
        
        result
    }
    
    // Utility: check if character is vowel
    fn is_vowel(c: char) -> bool {
        matches!(c, 'a' | 'e' | 'i' | 'o' | 'u' |
                    'A' | 'E' | 'I' | 'O' | 'U')
    }
}
