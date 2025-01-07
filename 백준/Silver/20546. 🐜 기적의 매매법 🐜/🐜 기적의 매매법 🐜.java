import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] jun = {cash, 0};
        int[] sung = {cash, 0};
        int[] stock = new int[14];
        for (int i = 0; i < 14; i++) {
            stock[i] = Integer.parseInt(st.nextToken());
        }

        int tmp = stock[0];
        int inc = 0;
        int dec = 0;

        for (int i = 0; i < 14; i++) {
            if (jun[0] >= stock[i]) {
                jun[1] += jun[0] / stock[i];
                jun[0] %= stock[i];
            }

            if (tmp < stock[i]) {
                inc++;
                dec = 0;
            } else if (tmp > stock[i]) {
                dec++;
                inc = 0;
            }

            if (inc >= 3) {
                sung[0] += sung[1] * stock[i];
                sung[1] = 0;
            }

            if (dec >= 3) {
                sung[1] += sung[0] / stock[i];
                sung[0] %= stock[i];
            }

            tmp = stock[i];
        }
        
        int junResult = jun[0] + (jun[1] * tmp);
        int sungResult = sung[0] + (sung[1] * tmp);

        if (junResult > sungResult) {
            System.out.println("BNP");
        } else if (junResult < sungResult) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }

    }
}