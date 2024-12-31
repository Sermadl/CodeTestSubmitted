import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][m];
            int[][] dp = new int[2][m+1];

            // 스티커 입력받기
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] tmp = new int[m];

                for (int k = 0; k < m; k++) {
                    tmp[k] = Integer.parseInt(st.nextToken());
                }

                sticker[j] = tmp;
            }

            // 규칙을 잘 찾아보자..!
            // 왼쪽 대각선 위 혹은 아래의 dp 또는 그 왼쪽 dp 중 더 큰 값과 현재 자신의 값을 더해주면 됨
            // dp의 길이를 하나 더 길게 해서 일부러 맨처음만 자기자신으로 초기화 시키고 2번째부터는
            // 0과 더해지게 해서 정상적으로 동작하게 만드는 코드가 많은 듯
            dp[0][1] = sticker[0][0];
            dp[1][1] = sticker[1][0];
            for (int j = 2; j < m + 1; j++) {
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + sticker[0][j-1];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + sticker[1][j-1];
            }

            System.out.println(Math.max(dp[0][m], dp[1][m]));
        }
    }
}
