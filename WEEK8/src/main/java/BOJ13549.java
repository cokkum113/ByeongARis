import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13549
{
    static int n;
    static int k;
    static int[] graph = new int[100001];
    static boolean[] visited = new boolean[100001];

    static int cnt = 0;

    static class Position {
        private int pos;
        private int cnt;

        public Position(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }

    public static int BFS(int n, int k) {
        int res = 0;
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(n, 0));

        while (!q.isEmpty()) {
            Position position = q.poll();
            int pos = position.pos;
            int cnt = position.cnt;

            if (pos == k) {
                res = cnt;
                break;
            }

            if (pos * 2 <= 1000000 && visited[pos * 2] == false) {
                visited[pos * 2] = true;
                q.offer(new Position(pos * 2, cnt));
            }
            if (pos - 1 < 1000000 && visited[pos - 1] == false) {
                visited[pos - 1] = true;
                q.offer(new Position(pos - 1, cnt + 1));
            }
            if (pos + 1 < 1000000 && visited[pos + 1] == false) {
                visited[pos + 1] = true;
                q.offer(new Position(pos + 1, cnt + 1));
            }

        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(BFS(n,k));

    }
}
