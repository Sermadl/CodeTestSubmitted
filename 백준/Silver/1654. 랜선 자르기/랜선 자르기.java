import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] ropes = new int[k];
        for (int i = 0; i < k; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        long min = 1;
        long max = ropes[k-1];

        while(min <= max) {
            long mid = (max + min) / 2;
            long sum = 0;

            for (int i = 0; i < k; i++) {
                sum += (ropes[i] / mid);
            }

            if (sum < n) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max);
    }
}