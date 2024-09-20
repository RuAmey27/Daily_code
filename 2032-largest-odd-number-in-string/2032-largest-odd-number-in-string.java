class Solution {
    public String largestOddNumber(String num) {
       for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                // Return the substring from the start to this index
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}