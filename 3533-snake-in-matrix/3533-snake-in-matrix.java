class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        HashMap<String,int[]> directions=new HashMap<>();
        directions.put("UP", new int[]{-1, 0});
        directions.put("DOWN", new int[]{1, 0});
        directions.put("LEFT", new int[]{0, -1});
        directions.put("RIGHT", new int[]{0, 1});

        int []initialpos={0,0};
        for(String direc:commands){
        int[]arr=directions.get(direc);
            initialpos[0]+=arr[0];
            initialpos[1]+=arr[1];

        }


        return initialpos[0]*n+initialpos[1];
    }
}