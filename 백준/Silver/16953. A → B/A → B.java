import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
       
        int cnt = 0;
        while(b > a) {
            if (b % 2 == 0) {
                b /= 2;
                cnt++;
            } else {
                if (b % 10 != 1) break;
                b = (b - 1) / 10;
                cnt++;
            }
        }
        
        if (b == a) System.out.print(cnt+1);
        else System.out.print(-1);
    }
}