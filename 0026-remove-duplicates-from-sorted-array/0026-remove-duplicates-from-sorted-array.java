class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0; // Pointer for the position of the last unique element

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++; // Move the slow pointer
                nums[i] = nums[j]; // Update the position with the new unique element
            }
        }

        return i + 1; // Leng
    }
}