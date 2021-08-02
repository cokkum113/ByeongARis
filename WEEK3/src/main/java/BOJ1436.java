import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1436
{
    //이 문제는 666을 하나로 보면 될거같다.
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String num = "666";

        int cnt = 0;
        int ans = 0;

        for(int i = 0; i < 10000001; i++)
        {
            String compare = String.valueOf(i);
            if (compare.contains(num))
            {
                cnt += 1;
                ans = Integer.parseInt(compare);
            }
            if (cnt == n)
            {
                System.out.println(ans);
                break;
            }
        }
    }
}
