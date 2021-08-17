import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);
        /*
        457 539 743 802 이렇게 되면 457로
        나머지 수들을 나누고 몫들을 더하면 K보다 작으면
        457을 나누기 2하고 이것들의 몫을 또 더해주고 크면 바꿔주고 하는 식으로 한번 해보면 될 거같음요,,,
         */

        /*
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            int x = 0;
            x = arr[i] / arr[0];
            cnt += x;
        }
        근데 이런식으로 하면 반복하기 힘들고 이상해짐
        이분탐색의 start, end, mid 를 써보기
         */
//        int start = arr[0];
        long start = 1;
        long end = arr[N - 1];

        long mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            long cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= K) {
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
