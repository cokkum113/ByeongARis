import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ10989
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        //카운팅 정렬
        //원소 갯수 - > 누적합 -> sorting by using 누적합

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] counting = new int[10001];
        int[] res = new int[N];

        for (int i = 0; i < N; i++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            arr[i] = x;
            counting[x]++;
        }
        //누적합
        for(int i = 1; i < counting.length; i++)
        {
            counting[i] += counting[i - 1];
        }
        //정렬
        for(int i = arr.length - 1 ; i >= 0; i--)
        {
            res[--counting[arr[i]]] = arr[i];
        }

        for(int i = 0; i < res.length;i++)
        {
            sb.append(res[i]).append('\n');
        }

        System.out.println(sb);
    }

}
