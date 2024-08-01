class Solution {
    public int countSeniors(String[] details) {
    int count = 0;
    for (String a : details) {
        StringBuilder arr = new StringBuilder();
        arr.append(a.charAt(11));
        arr.append(a.charAt(12));
        int b = Integer.parseInt(arr.toString());
        if (b > 60) {
            count++;
        }
    }
    return count;
}

}