class Solution {
    public int getLucky(String s, int k) {
        HashMap<Character, Integer> alphabetMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphabetMap.put((char) ('a' + i), i + 1);
        }

        StringBuilder numericString = new StringBuilder();
        for (char c : s.toCharArray()) {
            numericString.append(alphabetMap.get(c));
        }

        String currentString = numericString.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char digit : currentString.toCharArray()) {
                sum += digit - '0';
            }
            currentString = String.valueOf(sum);
        }

        return Integer.parseInt(currentString);
    }
}