import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] tree = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int start = 0;
        int end = tree[n - 1];

        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (tree[i] < mid) continue;

                sum += (tree[i] - mid);
            }

            if (sum >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start - 1);
    }
}