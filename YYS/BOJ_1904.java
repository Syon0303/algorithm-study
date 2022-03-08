import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 2];
        dp[0] = 1; // 1개일 때: 1
        dp[1] = 2; // 2개일 때: 2
        for (int i = 2; i < N; i++) { // i=2 일때 N=3
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }
        System.out.println(dp[N - 1]);
    }
}