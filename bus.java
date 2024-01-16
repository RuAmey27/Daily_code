import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        int t, x, y;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t != 0) {
            x = sc.nextInt();
            if (x <= 30) {
                if ((11 <= x) && (x <= 15)) {
                    System.out.println("Lower Single");
                } else {
                    if ((1 <= x) && (x <= 10)) {
                        System.out.println("Lower Double");

                    } else {
                        if ((26 <= x) && (x <= 30)) {
                            System.out.println("Upper Single");
                        } else {
                            System.out.println("Upper Double");
                        }
                    }
                }
            }
            t--;
        }
        sc.close();

    }
}
