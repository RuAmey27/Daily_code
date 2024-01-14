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
            int count=0;
            int arr[] = new int[x];
            for(int i=0;i<x;i++)
            {
                arr[i]= sc.nextInt();
                if(arr[i]>=y){
                    count++;
                }
            }
            System.out.println(count);
            t--;
		}
		
	}
}