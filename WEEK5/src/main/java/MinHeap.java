import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MinHeap
{
    public static class minHeap
    {
        private ArrayList<Integer> heap;

        public minHeap()
        {
            heap = new ArrayList<>();
            heap.add(0);
        }

        public void insert(int val)
        {
            heap.add(val);
            int p = heap.size() - 1;

            //힙 사이즈 -1이 1보다 작아질때까지 진행 -> root로 이동
            while (p > 1 && heap.get(p / 2) > heap.get(p))
            {
                System.out.println(" swap");
                //부모보다 자식이 작다면 바꿔야함
                int temp = heap.get(p / 2);
                heap.set(p / 2, heap.get(p));
                heap.set(p, temp);

                p = p / 2;
                //p는 부모값으로 변경 (부모 노드 인덱스로 이동)
            }
        }

        public int delete()
        {
            if (heap.size() - 1 < 1)
            {
                return 0;
            }
            int deleteItem = heap.get(1);

            //root에 가장 마지막 값 넣고 마지막 값 삭제
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

                if (heap.get(pos) < min)
                {
                    break;
                }
                int temp = heap.get(pos);
                heap.set(pos, heap.get(minPos));
                heap.set(minPos, temp);
            }
            return deleteItem;
        }



    }
}
