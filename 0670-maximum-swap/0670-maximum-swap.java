class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;

        for (int i = 0; i < n - 1; i++) {
            if (digits[i] < digits[i + 1]) {
                break;
            }
            if (i == n - 2) {
                return num;
            }
        }

        int maxIdx = n - 1;
        int leftIdx = -1, rightIdx = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] < digits[maxIdx]) {
                leftIdx = i;
                rightIdx = maxIdx;
            } else if (digits[i] > digits[maxIdx]) {
                maxIdx = i;
            }
        }

        if (leftIdx != -1) {
            char temp = digits[leftIdx];
            digits[leftIdx] = digits[rightIdx];
            digits[rightIdx] = temp;
        }

        return Integer.parseInt(new String(digits));
    }
}