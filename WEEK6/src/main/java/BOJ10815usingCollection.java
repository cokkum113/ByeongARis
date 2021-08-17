import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815usingCollection {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st2.nextToken());
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st3.nextToken());
        StringTokenizer st4 = new StringTokenizer(br.readLine());
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st4.nextToken());
        }
        Arrays.sort(arr1);

        /*
        이번 방식은 컬렉션 사용한 방법
         */
        int ans[] = new int[M];

        for (int i = 0; i < arr2.length; i++) {
            int x = Arrays.binarySearch(arr1, arr2[i]);
            if (x < 0) {
                ans[i] = 0;
            } else {
                ans[i] = 1;
            }
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
