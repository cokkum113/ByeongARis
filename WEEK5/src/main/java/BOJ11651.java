import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11651
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][2];

        for(int i = 0; i < N; i++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            arr[i][0] = x;
            arr[i][1] = y;
        }
        Arrays.sort(arr, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if(o1[1] == o2[1])
                {
                    return o1[0] - o2[0];
                }
                else
                {
                    return o1[1] - o2[1];
                }
            }
        });
        for(int i = 0; i < N; i++)
        {
            System.out.println(arr[i][0] + " "+ arr[i][1]);
        }

    }
}
