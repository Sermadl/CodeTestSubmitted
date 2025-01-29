import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.valueOf(1);

        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i - 1].multiply(BigInteger.valueOf(i));
        }

        System.out.println(dp[n].divide(dp[n - m]).divide(dp[m]));
    }
}