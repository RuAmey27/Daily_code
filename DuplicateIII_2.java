import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length <= 1 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        TreeSet<Long> values = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long currentNum = nums[i];

            // Check if there is a value in the TreeSet that is within the range [currentNum - valueDiff, currentNum + valueDiff]
            Long floor = values.floor(currentNum + (long) valueDiff);
            Long ceiling = values.ceiling(currentNum - (long) valueDiff);

            if ((floor != null && floor >= currentNum) || (ceiling != null && ceiling <= currentNum)) {
                return true;
            }

            values.add(currentNum);

            // Maintain the sliding window of size at most indexDiff
            if (i >= indexDiff) {
                values.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}