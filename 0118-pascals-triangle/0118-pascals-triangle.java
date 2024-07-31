class Solution {
    public static List<Integer> generateRow(int row){
        int  ans=1;

        List<Integer> arr= new ArrayList<>();
        arr.add(ans);
        for(int col=1;col<row;col++){
            ans=ans*(row-col);
            ans=ans/col;
            arr.add(ans);
        }

        return arr;
    }

    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> arr=new  ArrayList<>();
         for(int i=1;i<=numRows;i++){
            arr.add(generateRow(i));
         }
         return arr;
    }
}