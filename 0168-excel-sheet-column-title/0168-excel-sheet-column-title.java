class Solution {
    public String convertToTitle(int columnNumber) {
        HashMap<Character,Integer> mapping= new HashMap<>();
        int i=1;
        for(char ch='A';ch<='Z';ch++)
        {
            mapping.put(ch,i);
            i=i+1;
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // Adjust columnNumber to zero-based index
            int remainder = columnNumber % 26; // Find remainder
            char character = (char) ('A' + remainder); // Map remainder to character
            sb.append(character); // Append character to result
            columnNumber /= 26; // Reduce columnNumber
        }

        return sb.reverse().toString(); // Reverse the result and return

    }
}