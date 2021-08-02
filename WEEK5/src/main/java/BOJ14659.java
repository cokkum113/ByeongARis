import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.StringTokenizer;

public class BOJ14659
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int cnt = 0;

        for(int i = 0; i < N; i++)
        {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        int start = arr[0];
        int res = 0;

        for (int i = 1; i < N; i++)
        {
            if (start > arr[i])
            {
                cnt++;
            }
            else
            {
                start = arr[i];
                res = Math.max(cnt, res);
                cnt = 0;
            }
        }
        res = Math.max(res, cnt);
        System.out.println(res);

    }
}
