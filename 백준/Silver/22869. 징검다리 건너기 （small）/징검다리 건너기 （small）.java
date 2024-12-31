import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] bridge = new int[n];
        for (int i = 0; i < n; i++){
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        // 문제를 잘 읽자! 
        // 건너갈 때 필요한 최대 힘이기 때문에 현재 돌에서 다음 돌로 넘어갈 때 이동이 가능한지를 체크해두고,
        // 가능했던 돌에서 다시 다음 돌로 이동이 가능한지 체크하는 식으로 진행한다.
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            if (dp[i] == 1) {
                for (int j = i + 1; j < n; j++) {
                    if ((j - i) * (Math.abs(bridge[j] - bridge[i]) + 1) <= k) {
                        dp[j] = 1;
                    }
                }

            }
        }

        if (dp[n-1] == 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}