class Solution {
    public boolean doesValidArrayExist(int[] derived) {
    int n = derived.length;
    
    // Check both possible values for original[0]
    for (int firstBit = 0; firstBit <= 1; firstBit++) {
        int[] original = new int[n];
        original[0] = firstBit;
        
        // Compute all other values of original based on the relationship with derived
        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }
        
        // Check if the circular relationship holds for the last element
        if (derived[n - 1] == (original[n - 1] ^ original[0])) {
            return true;
        }
    }
    
    // No valid original array found
    return false;
}

}