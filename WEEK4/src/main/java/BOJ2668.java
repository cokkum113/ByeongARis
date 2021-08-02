import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2668
{
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int cnt;


    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            graph[i][k] = 1;
        }
        for(int i = 0; i < n; i++)
        {
            if (visited[i] == false)
            {
                dfs(i);
                cnt++;
            }
        }
        System.out.println("cnt = " + cnt);
    }


    public static void dfs(int u)
    {
        visited[u] = true;
        for (int i = 1; i < n + 1; i++)
        {
            if (visited[i] == false && graph[u][i] == 1)
            {
                dfs(i);
            }
        }

    }
    static class Position
    {
        private int pos;
        private int cnt;

        public Position(int pos, int cnt)
        {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
}
