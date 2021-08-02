import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1927
{
    public static class minHeap
    {
        private ArrayList<Integer> heap;

        public minHeap()
        {
            heap = new ArrayList<>();
            heap.add(0);
        }

        public void insert(int i)
        {
            heap.add(i);
            int p = heap.size() - 1;
            while (p > 1 && heap.get(p / 2) > heap.get(p))
            {
                int temp = heap.get(p / 2);
                heap.set(p / 2, heap.get(p));
                heap.set(p, temp);

                p = p / 2;
            }
        }

        public int delete()
        {
            if (heap.size() - 1 < 1)
            {
                return 0;
            }

            int deleteItem = heap.get(1);

            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int pos = 1;
            while ((pos * 2) < heap.size())
            {
                int min = heap.get(pos * 2);
                int minPos = pos * 2;


                if (((pos * 2 + 1) < heap.size()) && min > heap.get(pos * 2 + 1))
                {
                    min = heap.get(pos * 2 + 1);
                    minPos = pos * 2 + 1;
                }
                if (min > heap.get(pos))
                {
                    break;
                }
                int temp = heap.get(pos);
                heap.set(pos, heap.get(minPos));
                heap.set(minPos, temp);
                pos = minPos;
            }
            return deleteItem;
        }
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        minHeap heap1 = new minHeap();
        for (int j = 0; j < N; j++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            if (x == 0)
            {
                System.out.println(heap1.delete());
            } else
            {
                heap1.insert(x);

            }
        }
    }
}
