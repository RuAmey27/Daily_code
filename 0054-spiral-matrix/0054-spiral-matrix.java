class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> a=new ArrayList<>();
        if(matrix==null||matrix.length==0){
            return null;
        }

        int left=0; int right=matrix[0].length-1;
        int top=0; int bottom=matrix.length-1;

        while(top<=bottom && left<=right){
            for(int i=left; i<=right; i++){
                a.add(matrix[top][i]);  //row traversal
            }
            top++; //row shift;

            for(int i=top; i<=bottom; i++){
                a.add(matrix[i][right]); //column traversal
            }
            right--;  //column shift(decrease)

            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    a.add(matrix[bottom][i]); //row traversal
                }
                bottom--; //column shift(increase)
            }       

            if(left<=right){
                for(int i=bottom; i>=top; i--){
                    a.add(matrix[i][left]); //column traversal
                }
                left++; //row shift
            }
        }
        return a;
    }
}