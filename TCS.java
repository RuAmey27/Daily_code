
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */


class Codechef{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of test cases
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            // Input scores for Dragon
            int[] dragonScores = new int[3];
            for (int j = 0; j < 3; j++) {
                dragonScores[j] = scanner.nextInt();
            }

            // Input scores for Sloth
            int[] slothScores = new int[3];
            for (int j = 0; j < 3; j++) {
                slothScores[j] = scanner.nextInt();
            }

            // Compare scores and print the result
            String result = compareScores(dragonScores, slothScores);
            System.out.println(result);
        }

        scanner.close();
    }

    private static String compareScores(int[] dragonScores, int[] slothScores) {
        // Calculate total scores
        int dragonTotal = dragonScores[0] + dragonScores[1] + dragonScores[2];
        int slothTotal = slothScores[0] + slothScores[1] + slothScores[2];

        // Compare total scores
        if (dragonTotal > slothTotal) {
            return "Dragon";
        } else if (slothTotal > dragonTotal) {
            return "Sloth";
        } else {
            // Compare DSA scores
            if (dragonScores[0] > slothScores[0]) {
                return "Dragon";
            } else if (slothScores[0] > dragonScores[0]) {
                return "Sloth";
            } else {
                // Compare TOC scores
                if (dragonScores[1] > slothScores[1]) {
                    return "Dragon";
                } else if (slothScores[1] > dragonScores[1]) {
                    return "Sloth";
                } else {
                    return "Tie";
                }
            }
        }
    }
}
