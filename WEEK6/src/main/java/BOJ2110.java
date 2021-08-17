import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        int start = 1; //최소길이
        int end = arr[N - 1] - arr[0]; // 최대길이

        int res = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int left = arr[0];
            int cnt = 1;

            /*
            이 부분 솔직히 이해가 안됨
            왜냐면 left로 arr[0]으로 시작해서
            i = 1부터 시작해야한다고 생각하는데....
            왜냐면 그래서 cnt도 1부터 시작한건데
             */
            for (int i = 0; i < N; i++) {
                if (arr[i] - left >= mid) {
                    cnt++;
                    left = arr[i];
                }
            }
            if (cnt >= C) {
                start = mid + 1;
                res = mid;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(res);

    }
}
