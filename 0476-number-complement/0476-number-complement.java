class Solution {
    public int findComplement(int num) {
        int bitmask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ bitmask;
    }
}