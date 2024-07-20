class Solution {
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int ptr0=0;
        int ptr1=0;
        int ptr2=nums.length-1;

        while(ptr1<=ptr2){
            if(nums[ptr1]==0){
                swap(nums,ptr0,ptr1);
                ptr0++;
                ptr1++;
            }
            else if(nums[ptr1]==1){
                ptr1++;
            }
            else {
                swap(nums,ptr1,ptr2);
                ptr2--;
            }
        }
    }
}