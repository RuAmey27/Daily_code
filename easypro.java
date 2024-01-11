/**
 * Problem 1 codechef rating 1000
 */
import java.util.Set;
import java.util.HashSet;

class easypro{
    public static void main(String[] args) throws java.lang.Exception {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        String a = "schtschurowskia";
        int i = a.length();
        int count = 0;

        while (i > 0) {
            if (!vowels.contains(a.charAt(i - 1))) {
                count++;
                if (count >= 4) {
                    System.out.println("the word is hard");
                    break; // Once the condition is met, exit the loop
                }
            } else {
                count = 0;
            }
            i--;
        }
    }
}