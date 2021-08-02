import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int sum = 0;
        int total = 0;
        int[] arr = new int[N];

        for (int i = 0; i < nums.length; i++)
        {
            int num = Integer.parseInt(nums[i]);
            arr[i] = num;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            total += sum;
        }
        System.out.println(total);

    }
}
