import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ11650
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] nums = new int[N][2];
        String[] str = new String[2];

        for (int i = 0; i < N; i++)
        {
            str = br.readLine().split(" ");
            nums[i][0] = Integer.parseInt(str[0]);
            nums[i][1] = Integer.parseInt(str[1]);
        }

        //Comparator 재정의해서 써야함
        /*
        Comparator는 객체면 Collections, 배열이면 Arrays, int면 Integer
        sort(정렬대상 즉, 대상을 담은 list나 2차원 배열)
        ,new Comparator<int[]>() 이 순서대로 쓰기
         */


        Arrays.sort(nums, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if (o1[0] == o2[0])
                {
                    return Integer.compare(o1[1], o2[1]);
                    //작은 값이 위로 가게 정렬 o1[1] - o2[1]
                }
                return Integer.compare(o1[0], o2[0]);
                //1열부터 값이 차이가 있으니, 1열을 기준으로 먼저 정렬
            }
        });

        for (int[] ans : nums)
        {
            System.out.println(ans[0] + " " + ans[1]);
        }
    }

}
