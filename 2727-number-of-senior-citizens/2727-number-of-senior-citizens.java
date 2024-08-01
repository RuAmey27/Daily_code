class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String a : details) {
            int b = Integer.parseInt(a.substring(11, 13));
            if (b > 60) {
                count++;
            }
        }
        return count;
    }
}