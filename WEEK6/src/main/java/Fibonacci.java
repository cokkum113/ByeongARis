import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fibonacci {

    static int[] memo;

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        else if (n == 2) {
            return 1;
        } else {
            if (memo[n] > 0) {
                return memo[n];
            }
            memo[n] = fibo(n - 1) + fibo(n - 2);
            return memo[n];
        }

    }
    /*
    top-down
    1. 큰문제를 작은 문제로 나눈다 F(N-1), F(N-2)로 나눈다
    2. 작은 문제로 푼다 F(N-1) +  F(N-2)

    -> 재귀로 풀면됨.
     */


    /**
    Bottom-Up

    1. 문제를 크기가 작은 문제부터 차례대로 쓴다.
    2. 문제의 크기를 조금씩 크게 만들면서 문제를 푼다.
    3. 작은 문제를 풀면서 큰 문제의 답을 구한다.
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];

        System.out.println(fibo(n));
        //n번째 피보나치 수

    }


}
