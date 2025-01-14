import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long start = 0;
        long end = n;
        long answer = 0;

        while(start <= end) {
            long mid = (start + end) / 2;
            if (Math.pow(mid, 2) >= n) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }
}