import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PrimitiveIterator;
import java.util.StringTokenizer;

public class BOJ1012
{
    /*
    연결요소 문제이다.
     */
    static int N;
    static int M;
    static int K;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] graph;
    static boolean[][] visited;
    static int cnt;

    static void dfs(int y, int x)
    {
        int nx;
        int ny;

        for (int i = 0; i < 4; i ++)
        {
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < M && ny < N)
            {
                if (graph[ny][nx] == 1 && visited[ny][nx] == false)
                {
                    visited[ny][nx] = true;
                    dfs(ny, nx);
                }

            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st2.nextToken());
            N = Integer.parseInt(st2.nextToken());
            K = Integer.parseInt(st2.nextToken());
            graph = new int[N][M];
            visited = new boolean[N][M];
            cnt = 0;

            //배추
            for (int j = 0; j < K; j++)
            {
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st3.nextToken());
                int y = Integer.parseInt((st3.nextToken()));
                graph[y][x] = 1;
            }
            //지렁이갯수세기 카운트값.
            // 이부분 행 렬 바뀌는거 궁금 왜바뀌나 둘이 크기차이가 없는데 누가 큰줄알고
            for (int a = 0; a < N; a++)
            {
                for (int b = 0; b < M; b++)
                {
                    if (graph[a][b] == 1 && visited[a][b] == false)
                    {
                        cnt++;
                        visited[a][b] = true;
                        dfs(a,b);
                    }
                }
            }
            System.out.println(cnt);
        }

    }
}
