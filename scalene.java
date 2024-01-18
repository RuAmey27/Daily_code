import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if(a!=b&&b!=c&&a!=c){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            // Your code goes here
        }
    }
}
