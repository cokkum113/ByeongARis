import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963
{
    static int w;
    static int h;
    static int[][] graph;
    static boolean[][] visited;
    static int x;
    static int y;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0)
            {
                break;
            }
            graph = new int[h][w];
            visited = new boolean[h][w];
            int cnt = 0;

            for (int i = 0; i < h; i++)
            {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++)
                {
                    graph[i][j] = Integer.parseInt(st2.nextToken());
                }
            }
            for (int i = 0; i < h; i++)
            {
                for (int j = 0; j < w; j++)
                {
                    if (visited[i][j] == false && graph[i][j] == 1)
                    {
                        dfs(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }

    }

    public static void dfs(int y, int x)
    {
        visited[y][x] = true;
        int nx;
        int ny;
        for (int i = 0; i < 8; i ++)
        {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < w && 0 <= nx && ny < h && 0 <= ny && graph[ny][nx] == 1 && visited[ny][nx] == false)
            {
                dfs(ny, nx);

            }
        }
    }
}
