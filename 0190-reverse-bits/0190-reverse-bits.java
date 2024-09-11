public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
      n = (n >>> 16) | (n << 16);                   
    n = ((n & 0xFF00FF00) >>> 8) | ((n & 0x00FF00FF) << 8); // Swap 8-bit chunks
    n = ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0F0F0F0F) << 4); // Swap 4-bit chunks
    n = ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2); // Swap 2-bit chunks
    n = ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1); // Swap single bits
    return n;
    }
}