import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // Number of test cases

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt(); // Number of problems
            int X = scanner.nextInt(); // Maximum score for each problem
            int Y = scanner.nextInt(); // Desired total score

            // Check if it's possible for Chef to achieve exactly Y marks
            if (Y <= N * X && Y % X == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}