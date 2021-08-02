import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11866
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        /*

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 1; i < N + 1; i++)
        {
            arr.add(i);
        }

        int start = 0;

        while (arr.size() > 0)
        {
            int x = arr.get(start + K);
            arr2.add(x);
            arr.remove(start + K);
            //이렇게도해주고, 시작부분이 바뀌어야함 갱신되어야함
            start += 3;
            //이렇게해주면 일차원배열이라서 내가 생각하는대로안됨
        }

 */

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < N + 1; i++)
        {
            queue.add(i);
        }

        while (!queue.isEmpty())
        {
            for(int i = 0; i < K - 1; i++)
            {
                int x = queue.poll();
                queue.offer(x);
            }
            int ans = queue.poll();
            arr.add(ans);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i : arr)
        {
            sb.append(i);
            N--;
            if (N > 0)
            {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}
