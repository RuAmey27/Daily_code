/* package codechef; // don't place package name! */
import java.util.Scanner;
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        int t;

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        while (t != 0) {
            int x = sc.nextInt();
            char a[] = new char[x];
            int i = 0;

            // Read the input string
            String inputString = sc.next();

            // Check if the input string is not empty
            while (i < x && i < inputString.length()) {
                char in = inputString.charAt(i);

                if (in == 'A') {
                    a[i] = 'T';
                } else if (in == 'T') {
                    a[i] = 'A';
                } else if (in == 'C') {
                    a[i] = 'G';
                } else {
                    a[i] = 'C';
                }

                i++;
            }

            for (int j = 0; j < x; j++) {
                System.out.print(a[j]);
            }

            System.out.println(); 
            t--;
        }

        sc.close();
    }
}
