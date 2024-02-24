import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int L = scanner.nextInt();
        int R = scanner.nextInt();

        // Right-shift N by R positions
        int shiftedRight = N >> R;

        // Left-shift the result of the right shift by L positions
        int finalResult = shiftedRight << L;

        // Print the final result
        System.out.println( finalResult);

        scanner.close();
    }
}
