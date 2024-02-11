import java.util.Scanner;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();

            if (areEqual(a, b, x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean areEqual(int a, int b, int x) {

        if (a < b) {
            if ((b - a) % x == 0) {
                return true;
            }

        } else if (a > b) {
            if ((a - b) % x == 0) {
                return true;
            }
        } else {
            return false;
        }

    }
}