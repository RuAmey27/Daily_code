import java.util.*;
class Codechef {

    public static int msb(int number){
    {
        
    int msb = 0;

    while(number > 0){
        number = number >> 1;  // Right shift by 1 to move to the next bit
        msb = msb + 1;
    }

    return msb - 1; 
    // Subtract 1 to get the 0-based position
    }
}
    
	public static void main (String[] args) 
	{
		// your code goes here
		int t,x,y;
		Scanner sc=new Scanner(System.in);
		x = sc.nextInt();
		t=msb(x);
		y=(x&1);
		System.out.println(t);
		System.out.print(y);
		
	}

}