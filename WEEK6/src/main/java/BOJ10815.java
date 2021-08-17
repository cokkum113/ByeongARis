import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
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

        int[] ans = new int[M];


        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = N - 1;
            int mid;

            while (start <= end) {
                mid  = (start  + end) / 2;

                if (arr2[i] == arr1[mid]) {
                    ans[i] = 1;
                    break;
                }
                if (arr2[i] < arr1[mid]) {
                    end = mid - 1;
                } else if (arr2[i] > arr1[mid]) {
                    start = mid + 1;
                }
                else {
                    ans[i] = 0;
                }
            }
        }
        for (int i : ans) {
            System.out.print(i+" ");
        }
    }
}
