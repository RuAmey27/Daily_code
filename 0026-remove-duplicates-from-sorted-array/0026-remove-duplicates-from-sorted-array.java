class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> uniqueSet = new HashSet<>();
        
        int index = 0; // Pointer to track the position of unique elements
        
        for (int num : nums) {
            // If the number is not already in the HashSet, it's unique
            if (uniqueSet.add(num)) {
                nums[index++] = num; // Place the unique number in the array
            }
        }
        
        return index; // The le
    }
}