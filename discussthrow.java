class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int t,x,y,z;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t!=0)
		{
            x=sc.nextInt();
            y=sc.nextInt();
            z=sc.nextInt();
            if((x>=y)&&(x>=z)){
            System.out.println(x);
            }else{
                if((y>=x)&&(y>=z)){
                    System.out.println(y);
                }
                else{
                    System.out.println(z);
                }
            }
            t--;
		}
		
	}
}
