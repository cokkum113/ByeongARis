import org.xml.sax.helpers.AttributesImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = 0;


        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }
        int sec = Integer.MAX_VALUE;
        int height = -1;

        for (int i = min; i <= max; i++) {
            int time = 0;
            int block = b;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int diff = map[j][k] - i;
                    if (diff> 0) {
                        time += Math.abs(diff) * 2;
                        block += Math.abs(diff);
                    } else if (diff < 0) {
                        time += Math.abs(diff);
                        block -= Math.abs(diff);
                    }
                }
            }
            if (block < 0) {
                continue;
            }
            if (sec >= time) {
                sec = time;
                height = i;
            }
        }

        System.out.println(sec + " " + height);

    }
}
