import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1449
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        L = L - 1;
        //양쪽의 0.5개를 미리 빼주면 됨.

        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
        {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);

        int start = arr[0];
        int end = 0;
//        int cnt = 0; 이렇게 시작하려면 어딜 바꿔야하지?
        int cnt = 1;

        for (int i = 0; i < N; i++)
        {
            end = start + L;
            if (arr[i] <= end)
            {
                continue;
            }
            else
            {
                start = arr[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
