import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int cnt = 0;

        if (n > 4) {
            cnt += n / 5;
            n %= 5;
            
            if (n % 2 == 0) {
                cnt += n / 2;
                n %= 2;
            } else {
                cnt--;
                n += 5;
                cnt += n / 2;
                n %= 2;
            } 
        } else {
            cnt += n / 2;
            n %= 2;
        }

        
        if (n > 0) {
            System.out.print(-1);
        } else {
            System.out.print(cnt);
        }
    }
}