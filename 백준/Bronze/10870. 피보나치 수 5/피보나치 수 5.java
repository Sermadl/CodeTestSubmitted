import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0) System.out.println(0);
        else if (n == 1) System.out.println(1);
        else {
            int fibonacci[] = new int[n + 1];
            fibonacci[0] = 0;
            fibonacci[1] = 1;

            for (int i = 2; i <= n; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }

            System.out.println(fibonacci[n]);
        }
    }
}