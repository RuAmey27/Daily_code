class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out=new ArrayList<>();
        int n= nums.length;
        int N= (int)Math.pow(2,n);
        for(int i=0;i<N;i++){
            List<Integer> arr=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & (1 << j)) != 0){
                    arr.add(nums[j]);
                }
            }
            out.add(arr);
        }

        return out;

    }
}