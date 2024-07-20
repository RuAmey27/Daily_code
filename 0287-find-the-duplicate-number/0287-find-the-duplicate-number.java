class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        HashSet<Integer> num=new HashSet<>();

        for(int i=0;i<n;i++){
            if(num.contains(nums[i])){
                
                return nums[i];
                
            }
            num.add(nums[i]);
            
            // for(int j=i+1;j<n;j++){
            //     if(nums[i]==nums[j]){
            //         return nums[i];
            //     }
            // }
        }
        return 0;
    
}
}