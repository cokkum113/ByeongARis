import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018
{
    static char graph1[][] = {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };

    static char graph2[][] ={
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}
    };

    public static void main(String[] args) throws Exception
    {
        /*
        이 문제는 내가 보드를 두개 만들어 놓고 끼워넣는 식으로 풀면 될거같다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        int min = 64;

        //그러고 칸이 안맞으면 카운트해주고 그 카운트해준것들의 최솟값을 내뱉으면 될듯하다
        //일단 그래프 입력받기
        for (int i = 0; i < N; i++)
        {
            String str = br.readLine();
            for (int j = 0; j < M; j++)
            {
                char color = str.charAt(j);
                arr[i][j] = color;
            }
        }

        for (int i = 0; i <= N - 8; i++)
        {
            for (int j = 0; j <= M - 8; j++)
            {
                int cnt1 = 0; // graph1 이랑 비교해서 다를때 cnt
                int cnt2 = 0; // graph2 랑 비교해서 다를 떄 cnt
                for (int k = 0; k < 8; k++)
                {
                    for (int u = 0; u < 8; u++)
                    {
                        if (arr[i + k][j + u] != graph1[k][u])
                        {
                            cnt1++;
                        }
                        if (arr[i + k][j + u] != graph2[k][u])
                        {
                            cnt2++;
                        }
                    }
                }
                if (min > cnt1)
                {
                    min = cnt1;
                }
                if (min > cnt2)
                {
                    min = cnt2;
                }

            }
        }
        System.out.println(min);

    }

}
