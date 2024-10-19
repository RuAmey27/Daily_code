class Solution {
    public char findKthBit(int n, int k) {
   while (n > 1) {
            int length = (1 << n) - 1;  // Length of Sn
            int mid = length / 2 + 1;   // Middle index of Sn
            
            if (k == mid) {
                return '1';  // Middle character is always '1'
            } else if (k > mid) {
                k = length - k + 1;  // Mirror the index to the first half
               char i = invert(findKthBit(n - 1, k));  // Invert the result
                return i;
            } else {
                n--;  // Move to Sn-1 if k is in the first half
            }
        }
        
        return '0';  // Base case for S1
    }

    private char invert(char bit) {
        return bit == '0' ? '1' : '0';
    }
}