class Solution {
    public int bitwiseComplement(int n) {

        if (n == 0) {
            return 1;
        }
        int bitmask = (Integer.highestOneBit(n) << 1) - 1;
        return n ^ bitmask;
    }
}