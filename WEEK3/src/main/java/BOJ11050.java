import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11050
{
    public static int fact(int u)
    {
        if (u == 0 || u == 1)
        {
            return 1;
        }
        return u * fact(u-1);
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int up = fact(N);
        int down = fact(N - K) * fact(K);

        System.out.println(up/down);

    }


}
