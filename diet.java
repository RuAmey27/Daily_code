
import java.util.Scanner;

class ChefDiet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of days
            int k = sc.nextInt(); // Amount of protein to eat daily
            int[] protein = new int[n];

            for (int i = 0; i < n; i++) {
                protein[i] = sc.nextInt(); // Protein bought in the morning
            }

            solveDietProblem(n, k, protein);
        }

        sc.close();
    }

    static void solveDietProblem(int n, int k, int[] protein) {
        int remainingProtein = 0;
        // int day = 0;

        for (int i = 0; i < n; i++) {
            remainingProtein += protein[i];

            if (remainingProtein < k) {
                System.out.println("NO " + (i + 1));
                return;
            }

            remainingProtein -= k;
        }

        System.out.println("YES");
    }
}
 