/*accepted solution */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seenNumbers = new HashSet<>();

        for (int num : nums) {
            if (seenNumbers.contains(num)) {
                return true;
            }
            seenNumbers.add(num);
        }

        return false;
    }
}
/*Time limit exceeds */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int i=nums.length-1;
       while(i!=-1)
       {
           for(int j=1;j<nums.length;j++)
           {
               if(nums[i]==nums[j]&&i!=j){
                   return true;
               }
           }
           i--;
       }
       return false;
    }
}