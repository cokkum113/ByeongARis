import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19939
{
    static int[] arr;
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[K];

        int sum = 0;

        for(int i = 1; i <= K; i++)
        {
            sum += i;
        }

        N -= sum;

        if (N < 0)
        {
            System.out.println(-1);
            return;
        }
        if (N % K == 0)
        {
            System.out.println(K - 1);
        }
        else
        {
            System.out.println(K);
        }
    }
}
