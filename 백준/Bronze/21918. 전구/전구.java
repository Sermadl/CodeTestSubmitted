import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] light = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());

            switch(cmd) {
                case 1:
                    light[a] = b;
                    break;
                case 2:
                    for (int j = a; j < b; j++) {
                        if (light[j] == 0) light[j] = 1;
                        else light[j] = 0;
                    }
                    break;
                case 3:
                    for (int j = a; j < b; j++) {
                        light[j] = 0;
                    }
                    break;
                case 4:
                    for (int j = a; j < b; j++) {
                        light[j] = 1;
                    }
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(light[i] + " ");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}