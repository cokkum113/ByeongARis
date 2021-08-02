import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1946
{
    /*
    내가 나누기 2 말한이유가 x로 정렬하면
    그 위에부분은 다 맞으니까 마치 1은 무조건 되는거처럼
    그래서 2를 나누는 거였음, 근데 아님
     */
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());


        while (T>0)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st2.nextToken());

            int[] arr = new int[N+1];
            for (int j = 0; j < N; j++)
            {
                
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                int grade1 = Integer.parseInt(st3.nextToken());
                int grade2 = Integer.parseInt(st3.nextToken());

                arr[grade1] = grade2;
            }
            int cnt = 1;
            //X가 1일때는 무조건이니까 1부터 시작하도록
            int y = arr[1]; //비교 대상 왜냐면 그 다음부터는 이 1번보다 무조건 높아야함

            for (int j = 2; j <= N; j++)
            {
                if (y >= arr[j])
                {
                    y = arr[j];
                    cnt++;
                }
            }

            System.out.println(cnt);
            T--;
        }
    }
}
