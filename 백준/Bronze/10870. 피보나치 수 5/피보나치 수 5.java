import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) bw.write("0");
        else if (n == 1) bw.write("1");
        else {
            int fibonacci[] = new int[n + 1];
            fibonacci[0] = 0;
            fibonacci[1] = 1;

            for (int i = 2; i <= n; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }

            bw.write(String.valueOf(fibonacci[n]));
        }
        
        bw.flush();
        bw.close();
    }
}