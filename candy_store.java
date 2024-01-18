import java.util.*;
/* Name of the class has to be "Main" only if the class is public. */
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
            if(y>x){
                System.out.println((y-x)*2+x);
            }else{
                System.out.println(y);
            }
            t--;
		}
		
	}
}
