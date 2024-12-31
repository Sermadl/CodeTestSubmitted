import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][n];
        int[][] dp = new int[n+1][n+1];
        
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[n];
            st = new StringTokenizer(br.readLine(), " ");
            
            for (int j = 0; j < n; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());;
            }
            
            arr[i] = tmp;
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i - 1][j - 1];
            }
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            
            int sum = dp[ex][ey] - dp[sx - 1][ey] - dp[ex][sy - 1] + dp[sx - 1][sy - 1];
            
            bw.write(String.valueOf(sum) + "\n");
            bw.flush();
        }
        
        bw.close();
    }
}