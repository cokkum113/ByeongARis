import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697
{
    /*
     정점은 위치가 아니라 상태!!!!!!!!!!
     */
    private static int N;
    private static int K;
    private static int[] map = new int[100001];
    private static boolean[] visited = new boolean[100001];
    
    private static int cnt = 0;

    static class Postion
    {
        private int pos;
        private int cnt;

        public Postion(int pos, int cnt)
        {
            this.pos = pos;
            this.cnt = cnt;
        }

    }


    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int ans = bfs(N, K);
        System.out.println(ans);

    }
    public static int bfs(int N, int K)
    {
        int res = 0;
        Queue<Postion> queue = new LinkedList<>();
        queue.offer(new Postion(N, 0));

        while (!queue.isEmpty())
        {
            Postion postion = queue.poll();
            int pos = postion.pos;
            int cnt = postion.cnt;

            if (pos == K)
            {
                res = cnt;
                break;
            }
            if (pos * 2 <= 100000 && visited[pos * 2] == false)
            {
                visited[pos * 2] = true;
                queue.offer(new Postion(pos * 2, cnt + 1));
            }
            if (pos - 1 >= 0 && visited[pos - 1] == false)
            {
                visited[pos - 1] = true;
                queue.offer(new Postion(pos - 1, cnt + 1));
            }
            if (pos + 1 <= 100000 && visited[pos + 1] == false)
            {
                visited[pos + 1] = true;
                queue.offer(new Postion(pos + 1, cnt + 1));
            }

        }

        return res;

    }
    
}
