import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2217 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);

        int max = -1;
        for (int i = 0; i < N; i++) {
            int w = arr[i] * (N - i);
            if (w > max) {
                max = w;
            }

        }
        bw.write(String.valueOf(max));
        bw.flush();
    }
}
