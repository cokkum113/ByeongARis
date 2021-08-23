import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node1 implements Comparable<Node1> {

    private int x;
    private int y;
    private int distance;

    public Node1(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node1 other) {
        if(this.distance < other.distance){
            return -1;
        }
        return 1;
    }
}
public class BOJ1261 {

    public static final int INF = (int) 1e9;

    static int m;
    static int n;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static int[][] graph;
    public static int[][] d;
    public static PriorityQueue<Node1> pq;

    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][m + 1];
        d = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                d[i][j] = INF;
            }
        }

        for (int y = 1; y < n + 1; y++) {
            String[] str = reader.readLine().split("");
            for (int x = 1; x < m + 1; x++) {
                graph[y][x] = Integer.parseInt(str[x-1]);
            }
        }

        pq = new PriorityQueue<>();

        dijkstra();
        System.out.println(res);

    }

    public static int dijkstra() {
        pq.offer(new Node1(1, 1, 0));
        d[1][1] = 0;

        while (!pq.isEmpty()) {
            Node1 node1 = pq.poll();

            if (node1.getX() == m && node1.getY() == n) {
                res = node1.getDistance();
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node1.getX() + dx[i];
                int ny = node1.getY() + dy[i];

                if (nx > 0 && nx <= m && ny > 0 && ny <= n) {
                    if (d[ny][nx] > d[node1.getY()][node1.getX()] + graph[ny][nx]) {
                        d[ny][nx] = d[node1.getY()][node1.getX()] + graph[ny][nx];
                        pq.add(new Node1(nx, ny, d[ny][nx]));
                    }
                }
            }

        }
        return res;
    }


}
