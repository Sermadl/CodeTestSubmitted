import java.io.*;
import java.util.*;

class Main {
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp = new int[30][30];
        
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            System.out.println(combination(n, m));
        }
    }
    
    private static int combination(int r, int n) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        } else if (n == r || r == 0) {
            return dp[n][r] = 1;
        } else {
            return dp[n][r] = combination(r - 1, n - 1) + combination(r, n - 1);
        }
    }
}