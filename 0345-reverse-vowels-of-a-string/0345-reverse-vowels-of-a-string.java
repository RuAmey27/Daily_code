class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

         List<Character> vowelList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                vowelList.add(c);
            }
        }


        int left = 0;
        int right = vowelList.size() - 1;
        while (left < right) {
            char temp = vowelList.get(left);
            vowelList.set(left, vowelList.get(right));
            vowelList.set(right, temp);
            left++;
            right--;
        }


         StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                result.append(vowelList.remove(0));
            } else {
                result.append(c);
            }
        }
        
        return result.toString();

    }
}