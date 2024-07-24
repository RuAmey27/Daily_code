class Solution {
    private static int mapValue(int num, int[] mapping) {
        String numStr = Integer.toString(num);
        StringBuilder mappedStr = new StringBuilder();

        for (char c : numStr.toCharArray()) {
            int digit = c - '0';
            mappedStr.append(mapping[digit]);
        }

        return Integer.parseInt(mappedStr.toString());
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<Pair> mappedNums = new ArrayList<>();
        for (int num : nums) {
            int mappedValue = mapValue(num, mapping);
            mappedNums.add(new Pair(num, mappedValue));
        }

        mappedNums.sort(Comparator.comparingInt(Pair::getMappedValue));

        int[] sortedNums = new int[nums.length];
        for (int i = 0; i < mappedNums.size(); i++) {
            sortedNums[i] = mappedNums.get(i).getNumber();
        }

        return sortedNums;
    }

    private static class Pair {
        private final int number;
        private final int mappedValue;

        public Pair(int number, int mappedValue) {
            this.number = number;
            this.mappedValue = mappedValue;
        }

        public int getNumber() {
            return number;
        }

        public int getMappedValue() {
            return mappedValue;
        }
    }

}