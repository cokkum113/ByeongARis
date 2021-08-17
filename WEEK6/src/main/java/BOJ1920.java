import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
        {
            int x = Integer.parseInt(st2.nextToken());
            arr1[i] = x;
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st3.nextToken());
        int[] arr2 = new int[M];
        StringTokenizer st4 = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++)
        {
            int x = Integer.parseInt(st4.nextToken());
            arr2[i] = x;
        }
        Arrays.sort(arr1);
//        Arrays.sort(arr2);

//        Arrays.binarySearch(arr1, arr2);
        for (int i = 0; i < arr2.length; i++)
        {
            int x = Arrays.binarySearch(arr1, arr2[i]);
//            System.out.println(Arrays.binarySearch(arr2, arr1[i]));
            if (x < 0)
            {
                System.out.println(0);
            } else
            {
                System.out.println(1);
            }

        }


        /*
        int start = 0;
        int end = N - 1;
        int mid = (start + end) / 2;

        while (start >= end)
        {
            Arrays.sort();
        }

         */
    }
}
