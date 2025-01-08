import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] train = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int x;

            switch (cmd) {
                case 1:
                    x = Integer.parseInt(st.nextToken());
                    // i번째 기차와 1을 x만큼 왼쪽으로 비트 이동한 것을 비교
                    // 양쪽 비트 중 하나라도 1이면 무조건 1
                    train[t] |= (1 << x);
                    break;

                case 2:
                    x = Integer.parseInt(st.nextToken());
                    // i번째 기차와 1을 x만큼 왼쪽으로 비트 이동하여 반전한 것을 비교 (특정 위치의 사람만 하차시키기 위해)
                    // 양쪽 비트 중 하나라도 0이면 무조건 0, 둘 다 1이면 1 (원래 타 있던 사람 유지)
                    train[t] &= ~(1 << x);
                    break;

                case 3:
                    // 20번째 좌석에 있는 사람 하차시키고 한 칸씩 뒤로 가기
                    train[t] = (train[t] & ~(1 << 20)) << 1;
                    break;

                case 4:
                    // 첫번째 좌석에 있는 사람 하차시키고 한 칸씩 앞으로 가기
                    train[t] = (train[t] & ~(1 << 1)) >> 1;
                    break;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(train[i]);
        }

        System.out.println(set.size());
    }
}