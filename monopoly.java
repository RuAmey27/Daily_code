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
		int t,x,y,z,w;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t!=0)
		{
            x=sc.nextInt();
            y=sc.nextInt();
            z=sc.nextInt();
            w=sc.nextInt();
            if(x>y+z+w)
            {
                System.out.println("YES");
            }
            else
            {if(y>x+z+w)
                {
                    
                   System.out.println("YES"); 
                }
                else
                {
                   if(z>x+y+w) 
                    {
                        System.out.println("YES");
                    }
                    else{
                        if(w>x+y+z){
                            System.out.println("YES");
                        }
                        else
                        {
                            System.out.println("NO");
                        }
                        
                        
                    }
                    
                    
                    
                    
                }
            }
            t--;
		}
		
	}
}
