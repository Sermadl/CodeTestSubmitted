import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dp = new int[n];
        dp[0] = Integer.parseInt(st.nextToken());
        int max = dp[0];
        
        for (int i = 1; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            
            dp[i] = Math.max(dp[i - 1] + tmp, tmp);
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(max);
    }
}