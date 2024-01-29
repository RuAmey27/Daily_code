class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int t,x,y;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t!=0)
		{
            x=sc.nextInt();
            y=sc.nextInt();
            int withdraw[]=new int[x];
            int out[]=new int[x];
            for(int i=0;i<x;i++){
                withdraw[i]=sc.nextInt();
            }
            
            for(int i=0;i<x;i++){
                if(withdraw[i]<=y)
                {
                    out[i]=1;
                    y=y-withdraw[i];// know the difference between y=-x & y=y-x
                }
                else{
                    out[i]=0;
                }
            }
            /* The concept realized that is y=-x is negation and y-=x is equivlent with y=y-x*/
            for(int i=0;i<x;i++){
                 System.out.print(out[i]);
            }
            System.out.println("\n");
            t--;
		}
		
	}
}
