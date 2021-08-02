import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724
{
    static int N;
    static int M;
    static int[][] graph;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for(int i = 0; i < M; i++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        for (int i = 1; i < N + 1; i++)
        {

            if (visited[i] == false)
            {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    public static void dfs(int u)
    {
        visited[u] = true;
        for(int i = 1; i < N+1; i++)
        {
            if (visited[i] == false && graph[u][i] == 1)
            {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
