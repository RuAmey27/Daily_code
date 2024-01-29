class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int t,x,y,z,w;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t!=0)
		{
            x=sc.nextInt();
            y=sc.nextInt();
            z=sc.nextInt();
            w=sc.nextInt();
            int taste1 = (x+z)>(x+w) ? (x+z) : (x+w);
            int taste2 = (y+z)>(y+w) ? (y+z):(y+w);
            int max = taste2>taste1 ? taste2 :taste1;
            System.out.println(max);
            t--;
		}
		
	}
}
