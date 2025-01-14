import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0;
        long i = 1;
        
        while(true) {
            sum += i;
            if (sum > n) break;
            i++;
        }
        
        System.out.println(i - 1);
    }
}