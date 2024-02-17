/* package codechef; // don't place package name! */
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
		int arr[]=new int[t];
        x=sc.nextInt();
	    for(int i=0;i<t;i++)
	    {
	        arr[i]=sc.nextInt();
	    }
	    boolean a=ispresent(arr,x,t);
	    if(a==true){
	        System.out.println("YES");
	    }else{
	         System.out.println("NO");
	    }
	}
	public static boolean ispresent(int arr[], int key, int len)
	{
	    for(int i=0;i<len;i++)
	    {
	        if(arr[i]==key){
	            return true;  
	        }    
	    }
	    return false;
	}
}
