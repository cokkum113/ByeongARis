import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ10866
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < N; i++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String s1 = st2.nextToken();

            if (s1.equals("push_front"))
            {
                int X = Integer.parseInt(st2.nextToken());

                deque.addFirst(X);
            }
            else if (s1.equals("push_back"))
            {
                int X = Integer.parseInt(st2.nextToken());

                deque.addLast(X);
            }



            else if (s1.equals("pop_front"))
            {
                if (deque.isEmpty())
                {
                    System.out.println(-1);
                }
                else
                {
                    int Y  = deque.pollFirst();
                    System.out.println(Y);
                }

            }
            else if (s1.equals("pop_back"))
            {
                if (deque.isEmpty())
                {
                    System.out.println(-1);
                }
                else
                {
                    int Y  = deque.pollLast();
                    System.out.println(Y);
                }

            }
            else if (s1.equals("size"))
            {
                System.out.println(deque.size());
            }
            else if (s1.equals("empty"))
            {
                if (deque.isEmpty())
                {
                    System.out.println(1);
                }
                else
                {
                    System.out.println(0);
                }
            }
            else if (s1.equals("front"))
            {
                if (deque.isEmpty())
                {
                    System.out.println(-1);
                }
                else
                {
                    int Y  = deque.getFirst();
                    System.out.println(Y);
                }
            }
            else if (s1.equals("back"))
            {
                if (deque.isEmpty())
                {
                    System.out.println(-1);
                }
                else
                {
                    int Y  = deque.getLast();
                    System.out.println(Y);
                }
            }
        }
    }
}
