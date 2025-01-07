import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] light = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int tmpIdx = Integer.parseInt(st.nextToken());
            int idx = tmpIdx - 1;

            if (s == 1) {
                for (int j = idx; j < n; j += tmpIdx) {
                    if (light[j] == 1) {
                        light[j] = 0;
                    } else {
                        light[j] = 1;
                    }
                }


            } else {
                if (light[idx] == 1) {
                    light[idx] = 0;
                } else {
                    light[idx] = 1;
                }

                for (int j = 1; j < n / 2; j++) {
                    if (idx - j < 0 || idx + j > n - 1) {
                        break;
                    }

                    if (light[idx - j] == light[idx + j]) {
                        if (light[idx - j] == 1) {
                            light[idx - j] = 0;
                            light[idx + j] = 0;
                        } else {
                            light[idx- j] = 1;
                            light[idx + j] = 1;
                        }
                    } else break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(light[i] + " ");
            if ((i+1) % 20  == 0) bw.write("\n");
        }
        bw.close();
    }
}