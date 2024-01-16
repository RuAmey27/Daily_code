import java.util.*;
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
            if(x==y)
            {
                System.out.println("YES");
            }
            else if(x<y && y%x==0){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            t--;
		}
		sc.close();
	}
}