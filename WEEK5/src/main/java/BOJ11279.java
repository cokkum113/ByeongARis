import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11279
{
    public static class maxHeap
    {
        private ArrayList<Integer> heap;

        public maxHeap()
        {
            heap = new ArrayList<>();
            heap.add(1000000);
        }

        public void insert(int val)
        {
            heap.add(val);
            int p = heap.size() - 1;

            while (p > 1 && heap.get(p / 2) < heap.get(p))
            {
                int temp = heap.get(p / 2);
                heap.set(p / 2, heap.get(p));
                heap.set(p, temp);
                //특정인덱스값을 대체하는 메소드

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
                int max = heap.get(pos * 2);
                int maxPos = pos * 2;

                if (((pos * 2 + 1) < heap.size()) && max < heap.get(pos * 2 + 1))
                {
                    max = heap.get(pos * 2 + 1);
                    maxPos = pos * 2 + 1;

                }
                if (heap.get(pos) > max)
                {
                    break;
                }

                int temp = heap.get(pos);
                heap.set(pos, heap.get(maxPos));
                heap.set(maxPos, temp);
                pos = maxPos;

            }
            return deleteItem;
        }

    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        maxHeap heap = new maxHeap();
        for (int i = 0; i < N; i ++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            if (x == 0)
            {
                System.out.println(heap.delete());
            }
            heap.insert(x);

        }
    }

}
