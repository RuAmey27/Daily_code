class Solution {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        int i=1; //i points to last unique no passed 
        for(int j=1;j<len;j++)//j used to itertate to check other numbers
        {
            if(nums[j]!=nums[j-1]){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}