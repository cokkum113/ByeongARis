import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10816
{
    /*
    이 문제는 hash로 풀면 될거같다.
     */
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int plusAns[] = new int[10000001];
        int minusAns[] = new int[10000001];


        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for(int i = 0; i < nums.length; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }
        for(int i : nums)
        {
            int pluscnt = 0;
            int minuscnt = 0;

            if (i >= 0)
            {
                pluscnt ++;
                plusAns[i] += pluscnt;
            }

            else
            {
                minuscnt ++;
                minusAns[-i] += minuscnt;
            }
        }

        int M = Integer.parseInt(br.readLine());
        int a[] = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++)
        {
            int index = Integer.parseInt(st2.nextToken());
            if (index >= 0)
            {
                int answer = plusAns[index];
                a[i] = answer;
            }

            else
            {
                int answer = minusAns[-(index)];
                a[i] = answer;
            }
        }
        for (int i : a)
        {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
