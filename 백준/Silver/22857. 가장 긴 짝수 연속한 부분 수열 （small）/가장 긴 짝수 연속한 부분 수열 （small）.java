import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] num = new int[n + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[n + 1][k + 1];
        
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < k + 1; j++) {
                if (num[i] % 2 == 1) {
                    if (j == 0) continue;
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < k + 1; j++) {
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        System.out.println(answer);
    }
}