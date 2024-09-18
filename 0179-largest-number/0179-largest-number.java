class Solution {
 
    
       public String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, getComparator());

        if (numStrs[0].equals("0")) {
            return "0";
        }

        return String.join("", numStrs);
    }

    private Comparator<String> getComparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        };
}
}