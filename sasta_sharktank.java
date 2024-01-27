/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

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
            if(x*0.2>y*0.1)
            {
                System.out.println("FIRST");
            }
            else
            {if(x*0.2==y*0.1)
                {
                    System.out.println("ANY");
                    
                }
                else
                {
                    System.out.println("SECOND");
                }
            }
            t--;
		}
		
	}
}
