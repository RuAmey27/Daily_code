class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 26 lowercase letters
        int count = 0; // To store the number of times this prefix occurs
    }
    
    // Root of the Trie
    private TrieNode root = new TrieNode();
    
    // Method to insert a word into the Trie
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
            node.count++;  // Increment the count for this prefix
        }
    }
    
    // Method to calculate the score of a word based on its prefixes
    private int getScore(String word) {
        TrieNode node = root;
        int score = 0;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                break;
            }
            node = node.children[idx];
            score += node.count;  // Add the count of this prefix
        }
        return score;
    }
    public int[] sumPrefixScores(String[] words) {
         for (String word : words) {
            insert(word);
        }
        
        // Now calculate the scores for each word
        int n = words.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = getScore(words[i]);
        }
        
        return answer;
    }
}