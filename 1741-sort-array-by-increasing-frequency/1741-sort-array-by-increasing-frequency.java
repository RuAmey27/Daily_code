class Solution {
    public int[] frequencySort(int[] nums) {
       // Step 1: Count the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Get a list of keys and sort it based on frequency and value
        List<Integer> keys = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(keys, (a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);
            if (freqA != freqB) {
                return Integer.compare(freqA, freqB);  // Sort by frequency
            } else {
                return Integer.compare(b, a);  // If same frequency, sort by value descending
            }
        });

        // Step 3: Construct the result array
        int[] result = new int[nums.length];
        int index = 0;
        for (int key : keys) {
            int frequency = frequencyMap.get(key);
            for (int i = 0; i < frequency; i++) {
                result[index++] = key;
            }
        }

        return result;
    }

}