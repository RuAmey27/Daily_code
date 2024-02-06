import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
import java.util.Arrays;

class Codechef {

    public static int minMovesToSameNumber(int[] A) {
        // Sort the array
        Arrays.sort(A);

        int mode = A[0]; // Initialize mode as the first element
        int maxFreq = 1; // Initialize max frequency as 1
        int currentFreq = 1; // Initialize frequency counter for the current number
        
        // Iterate through the sorted array to find the mode and its frequency
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) {
                currentFreq++;
            } else {
                currentFreq = 1;
            }

            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                mode = A[i];
            }
        }

        // Calculate the minimum number of moves required
        int minMoves = A.length - maxFreq;

        return minMoves;
    }

    public static void main(String[] args) {
        int t;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        while(t!=0)
        {
            int x=sc.nextInt();
            int A[]=new int[x];
            for(int i=0;i<x;i++)
            {
                A[i]=sc.nextInt();
            }
            System.out.println(minMovesToSameNumber(A));
         t--;   
        } // Output: 3
    }
}
