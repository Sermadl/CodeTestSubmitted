import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int[] rope = new int[k];

        for (int i = 0; i < k; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);

        for (int i = k-1; i > -1; i--) {
            rope[i] *= (k - i);
        }

        Arrays.sort(rope);

        System.out.print(rope[k-1]);
    }
}
