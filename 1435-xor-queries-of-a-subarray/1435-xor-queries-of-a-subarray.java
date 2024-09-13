class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {

        int ans[]=new int[queries.length];
        int j=0;
        for(int row[] :queries){
            int l=row[0];
            int r=row[1];
            int xor=0;
            for(int i=l ;i<=r;i++){
                xor^=arr[i];
            }
            ans[j]=xor;
            j++;
        }
        
        return ans;
    }
}