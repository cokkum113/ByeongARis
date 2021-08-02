import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15903
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        minHeap heap = new minHeap();

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
        {
            int num = Integer.parseInt(st2.nextToken());
            heap.insert(num);
        }

        for (int j = 0; j < m; j++)
        {
            int sum = 0;
            int a = heap.delete();
            int b = heap.delete();
            sum = a + b;
            heap.insert(sum);
            heap.insert(sum);
        }
        int sum2 = 0;
        for (int k = 0; k < n; k++)
        {
            sum2 += heap.delete();
        }
        System.out.print(sum2);



    }
}