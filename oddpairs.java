
import java.util.Scanner;

class Codechef {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0) {
            int x = sc.nextInt(); 
            long o;
            o=countCombinations(x);
            System.out.println(o);
        }
    }
    private static long countCombinations(int N) {
        long evenCount = (N + 1) / 2; // Number of even numbers in range 1 to N
        long oddCount = N / 2; // Number of odd numbers in range 1 to N
        
        // Total number of combinations
        return (evenCount * oddCount) + (oddCount * evenCount);
    }
}