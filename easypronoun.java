/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */


class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next(); // Use sc.next() to read the input string directly
            char ch[] = s.toCharArray();

            int count = 0;
            boolean is = true;

            for (int j = 0; j < s.length(); j++) {
                if (ch[j] != 'a' && ch[j] != 'e' && ch[j] != 'i' && ch[j] != 'o' && ch[j] != 'u') {
                    count++;
                    if (count >= 4) {
                        is = false;
                        break; // No need to continue checking if count is already 4 or more
                    }
                } else {
                    count = 0; // Reset count only when a vowel is encountered
                }
            }

            if (is) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}