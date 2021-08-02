import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ9012
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++)
        {
            int cnt1 = 0;
            int cnt2 = 0;
            int[] cntArr = new int[2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            String ans = st.nextToken();
            for (int j = 0; j < ans.length(); j++)
            {
                char ans2 = ans.charAt(j);
                if (ans2 == '(')
                {
                    cnt1 += 1;
                    cntArr[0] = cnt1;
                } else if (ans2 == ')')
                {
                    cnt2 += 1;
                    cntArr[1] = cnt2;
                }
                if (cntArr[1] > cntArr[0])
                {
                    break;
                }
            }
            if (cntArr[0] == 0)
            {
                System.out.println("NO");
            } else if (cntArr[1] == 0)
            {
                System.out.println("NO");

            } else if (cntArr[0] == cntArr[1])
            {
                System.out.println("YES");
            } else
            {
                System.out.println("NO");
            }
        }

    }

}