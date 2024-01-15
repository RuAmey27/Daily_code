import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
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
            if(x==1|y==1|z==1|w==1)
            {
                System.out.println("OUT");
            }
            else{
                System.out.println("IN");
            }
            t--;
		}
		
	}
}
