class Solution {
   public boolean isHappy(int n) {
        HashSet<Integer> seen=new HashSet<>(); //used to determine if sum is repeating i.e cycle
        while(n!=1&& !seen.contains(n)){
            seen.add(n);// this add each sum that we have seen
            n=getNext(n);

        }

        if(n==1) return true;

        return false;

    }
    
    private int getNext(int n) {
        int sum=0;
        while(n>0){
            int d=n%10;
            n=n/10;
            sum+=d*d;
        }

        return sum;
    }
}