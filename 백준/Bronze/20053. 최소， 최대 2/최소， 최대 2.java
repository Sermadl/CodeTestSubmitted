import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int[][] result = new int[t][2];

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (min > num) {
                    min = num;
                }
                if (max < num) {
                    max = num;
                }
            }

            result[i][0] = min;
            result[i][1] = max;
        }

        for (int i = 0; i < t; i++) {
            bw.write(result[i][0] + " " + result[i][1] + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}