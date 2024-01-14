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
            if(x%4==0&&x>=4){
           System.out.println(x/4);}
           else if (x<4){
               System.out.println(1);
           } 
           else{
               System.out.println((x/4)+1);
           }
            t--;
		}
		
	}
}
