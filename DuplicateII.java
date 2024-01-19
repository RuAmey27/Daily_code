/* accepted solution */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];

            // Check if the current number is already in the map
            if (indexMap.containsKey(currentNum)) {
                // Check if the difference between current index and previous index is at most k
                if (i - indexMap.get(currentNum) <= k) {
                    return true;
                }
            }

            // Update the index of the current number in the map
            indexMap.put(currentNum, i);
        }

        return false;
    }
}
/*Time limit exceeds */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
         int i=nums.length-1;
       while(i!=-1)
       {
           for(int j=0;j<nums.length;j++)
           {
               if(nums[i]==nums[j]&&Math.abs(i-j)<=k&&i!=j){
                   return true;
               }
           }
           i--;
       }
       return false;
    }
}