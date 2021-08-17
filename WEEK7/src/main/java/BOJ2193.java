import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2193 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[91];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;

        for (int i = 5; i < N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }


        System.out.println(dp[N]);
    }
}
