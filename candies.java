/*Basically here in this problem we have to check if there is more than two occurence of any element in that array
 * if there present any element with more that two occurences we have to print "NO"
 * else we have to print "YES"
 * So we break down the work into three different task 
 * 1. count occureneces of the each element 
 * 2. check that if any element has more than two occurence 
 * 3. Task of printing
 */


import java.util.*;
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int countOccurrences(int[] arr, int element) {
        int count = 0;

        for (int value : arr) {
            if (value == element) {
                count++;
            }
        }

        return count;
    }// fun to return the occurences of the element in given array
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int t,x,y;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t!=0)
		{
            x=sc.nextInt();
            y=2*x;
            int arr[]=new int[y];
            for(int i=0;i<y;i++){
               arr[i]=sc.nextInt();
            }
            
            boolean val=true;// occurence vals are less than 2
              for (int value : arr) {
                int occ=countOccurrences(arr,value);
                if(occ>2){
                    val=false; // found element with more than two occurences
                    break;
                }
            }
            
            if(val==false){
                System.out.println("NO");
            }else{
                System.out.println("Yes");
            }// printing based on condition
            
            t--;
		}
		
	}
}
