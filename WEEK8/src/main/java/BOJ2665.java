import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node3 implements Comparable<Node3> {
    private int x;
    private int y;
    private int distance;

    public Node3(int x, int y, int distance) {
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
    public int compareTo(Node3 other) {
        if(this.distance < other.distance){
            return -1;
        }
        return 1;
    }
}
public class BOJ2665 {
    static int n;
    static int[][] graph;
    static int[][] d;
    static PriorityQueue<Node3> pq;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static final int INF = (int) 1e9;

    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        graph = new int[n + 1][n + 1];
        d = new int[n + 1][n + 1];

        for (int y = 1; y < n + 1; y++) {
            String[] str = reader.readLine().split("");
            for (int x = 1; x < n + 1; x++) {
                graph[y][x] = Integer.parseInt(str[x - 1]);
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                d[i][j] = INF;
                if (graph[i][j] == 1) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 1;
                }
            }
        }
        pq = new PriorityQueue<>();
        System.out.println(dijkstra());
    }

    public static int dijkstra() {
        pq.offer(new Node3(1, 1, 0));
        d[1][1] = 0;

        while (!pq.isEmpty()) {
            Node3 node3 = pq.poll();
            if (node3.getX() == n && node3.getY() == n) {
                res = node3.getDistance();
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node3.getX() + dx[i];
                int ny = node3.getY() + dy[i];

                if (nx > 0 && nx <= n && ny > 0 && ny <= n) {
                    if (d[ny][nx] > d[node3.getY()][node3.getX()] + graph[ny][nx]) {
                        d[ny][nx] = d[node3.getY()][node3.getX()] + graph[ny][nx];
                        pq.add(new Node3(nx, ny, d[ny][nx]));
                    }
                }
            }
        }


        return res;


    }
}
