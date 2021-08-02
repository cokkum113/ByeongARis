import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2751
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < N; i++)
        {
            int num = Integer.parseInt(br.readLine());
            nums.add(num);
        }

        Collections.sort(nums);

        for(int i = 0 ; i < nums.size(); i++)
        {
            bw.write(nums.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
