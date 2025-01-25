import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] energy = new int[n][2];
        
        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            energy[i][0] = Integer.parseInt(st.nextToken()); // 작은 점프
            energy[i][1] = Integer.parseInt(st.nextToken()); // 큰 점프
        }
        
        int k = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[n + 1][2];
        
        for (int i = 2; i <= n; i++) {
			Arrays.fill(dp[i], 10000);
		}
        
        if (n > 1) {
            dp[2][0] = energy[1][0];
        }
        
        if (n > 2) {
            dp[3][0] = Math.min(energy[1][1], dp[2][0] + energy[2][0]);
        }
        for (int i = 4; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + energy[i - 1][0], dp[i - 2][0] + energy[i - 2][1]);
            dp[i][1] = Math.min(
                Math.min(dp[i - 1][1] + energy[i - 1][0], dp[i - 2][1] + energy[i - 2][1]), 
                dp[i - 3][0] + k);
        }
        
        System.out.println(Math.min(dp[n][0], dp[n][1]));
    }
}