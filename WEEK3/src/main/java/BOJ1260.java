import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260
{
    static int[][] graph;
    static boolean[] visited;
    static boolean[] visited2;

    static int N;
    static int M;
    static int V;

    public static void dfs(int u)
    {
        visited[u] = true;
        System.out.print(u + " ");
        for (int i = 1; i < N + 1; i++)
        {
            if (graph[u][i] == 1 && visited[i] == false)
            {
                dfs(i);
            }
        }
    }

    public static void bfs(int u)
    {
        //Queue는 offer랑 poll
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(u);
        visited2[u] = true;

        while (!queue.isEmpty())
        {
            int temp = queue.poll();
            System.out.print(temp + " ");
            for(int i = 1; i < N + 1; i++)
            {
                if (graph[temp][i] == 1 && visited2[i] == false)
                {
                    queue.offer(i);
                    visited2[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        visited2 = new boolean[N + 1];

        for(int i = 0; i < M; i++)
        {
            String[] temp2 = br.readLine().split(" ");
            int a = Integer.parseInt(temp2[0]);
            int b = Integer.parseInt(temp2[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }


        dfs(V);
        System.out.println();
        bfs(V);
    }
}
