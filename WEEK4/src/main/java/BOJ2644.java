import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.PseudoColumnUsage;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2644
{
    /*
    bfs로 풀어보기, -1은 그냥 못찾았을 경우 flag를 하나 더 설정해줘서
    못찾으면 -1을 반환하도록하기.
     */
    static int n;
    static int m;
    static int graph[][];
    static boolean visited[];
    static int start;
    static int end;

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

    public static void bfs(int start, int end)
    {
        boolean isFind = false;
        Queue<Position> queue = new LinkedList<>();
        Position ps = new Position(start, 0);
        queue.offer(ps);
        visited[start] = true;

        while (!queue.isEmpty())
        {
            Position posx = queue.poll();
            int start2 = posx.pos;
            if (start2 == end)
            {
                isFind = true;
                System.out.println(posx.cnt);
                break;
            }
            for (int i = 1; i < n + 1; i ++)
            {
                if (graph[start2][i] == 1 && visited[i] == false)
                {
                    visited[i] = true;
                    Position position = new Position(i, posx.cnt++);
                    queue.offer(position);

                }
            }
        }
        if (isFind == false)
        {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st11 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st11.nextToken());
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st2.nextToken());


        for (int i = 0; i < m; i++)
        {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st3.nextToken());
            int y = Integer.parseInt(st3.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        bfs(start, end);

    }


}
