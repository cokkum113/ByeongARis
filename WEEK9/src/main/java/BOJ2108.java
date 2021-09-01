import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] arr2 = new int[8001];
        List<Integer> list = new ArrayList<>();

        int sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            arr2[arr[i] + 4000] += 1;
        }


        System.out.println((int) Math.round((double) sum / n));
        Arrays.sort(arr);
        System.out.println(arr[n / 2]);

        for (int i = 0; i < 8001; i++) {
            if (arr2[i] >= max) {
                max = arr2[i];
            }
        }

        for (int i = 0; i < 8001; i++) {
            if (arr2[i] == max) {
                list.add(i - 4000);
            }
        }
        if (list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            Collections.sort(list);
            System.out.println(list.get(1));
        }

        System.out.println(Math.abs(arr[arr.length - 1] - arr[0]));
    }
}
