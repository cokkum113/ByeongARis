import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class queu15903
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
        {
            pq.add(Long.parseLong(st2.nextToken()));
        }
        if (m != 0)
        {
            for (int j = 0; j < m; j++)
            {
                long sum = 0;
                long a = pq.poll();
                long b = pq.poll();
                sum =  a +  b;
                pq.add(sum);
                pq.add(sum);
            }
        }

        long sum2 = 0;
        for (int k = 0; k < n; k++)
        {
            long c = pq.poll();
            sum2 += c;
        }
        System.out.print(sum2);

    }
}

