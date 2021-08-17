import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1463 {
    static int N;
    static int[] memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        memo = new int[1000002];
        for (int i = 0; i < 1000002; i++) {
            memo[i] = -1;
        }

        memo[0] = 0;
        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 1;

        for (int i = 4; i < N + 1; i++) {
            int a = 1000001;
            int b = 1000001;

            if (i % 3 == 0) {
                a = memo[i / 3];
            }
            if (i % 2 == 0) {
                b = memo[i / 2];
            }
            int c = memo[i - 1];

            int d = Math.min(a, b);
            memo[i] = Math.min(c, d) + 1;
        }
        System.out.println(memo[N]);
    }
}
