import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class BFSDFS
{
    static int[][] graph;
    static boolean[] visited1;
    static boolean[] visited2;

    static int N;
    static int M;
    static int V;

    public static void dfs(int u)
    {
        visited1[u] = true;
        System.out.println("u = " + u);
        for(int i = 1; i < N+1; i++)
        {
            if(graph[u][i] == 1 && visited1[i] == false)
            {
                dfs(i);
            }
        }
    }

    public static void bfs(int u)
    {
        Queue<Integer> q = new LinkedList<>();
        q.offer(u);
        visited2[u] = true;




        while(!q.isEmpty())
        {
            int temp = q.poll();
            System.out.println("temp = " + temp);

            for (int i = 1; i < N + 1; i++)
            {

                if (graph[temp][i] == 1 && visited2[i] == false)
                {
                    q.offer(i);
                    visited2[i] = true;

                }
            }
        }
    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        visited1 = new boolean[N + 1];
        visited2 = new boolean[N + 1];

        for(int i = 0; i < M; i++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;

        }

        dfs(V);
        System.out.println();
        bfs(V);
    }
}
