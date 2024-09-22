class Solution {
    public List<Integer> lexicalOrder(int n) {
         List<Integer> result = new ArrayList<>();
    int current = 1;
    
    for (int i = 0; i < n; i++) {
        result.add(current);
        
        if (current * 10 <= n) {
            current *= 10; // Go to next level (child)
        } else {
            // Move to the next sibling or backtrack
            while (current % 10 == 9 || current + 1 > n) {
                current /= 10; // Backtrack to parent
            }
            current++; // Move to the next sibling
        }
    }
    
    return result;
    }
}