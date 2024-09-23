class Solution {
    public void sortColors(int[] nums) {
       int one = 0, two = 0, zero = 0;

        // Count the occurrences of 0, 1, and 2
        for (int num : nums) {
            if (num == 0) {
                zero++;
            } else if (num == 1) {
                one++;
            } else if (num == 2) {
                two++;
            }
        }

        // Overwrite the array based on the counts
        int i = 0;
        while (zero > 0) {
            nums[i++] = 0;
            zero--;
        }
        while (one > 0) {
            nums[i++] = 1;
            one--;
        }
        while (two > 0) {
            nums[i++] = 2;
            two--;
        } 
    }
}