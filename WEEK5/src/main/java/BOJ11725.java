import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725
{
    static boolean[] visited;
    static int[] parent;
    static ArrayList<Integer>[] arr;
    static int N;

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        arr = new ArrayList[N + 1];

        /*
        인접리스트 만들기
         */
        for(int i = 1; i < N+1; i++)
        {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            arr[x].add(y);
            arr[y].add(x);

        }
        dfs(1);
        for (int i = 2; i < N + 1; i++)
        {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int v)
    {
        visited[v] = true;
        for (int i : arr[v])
        {
            if (visited[i] == false)
            {
                parent[i] = v;
                dfs(i);
            }
        }
    }
}
