import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        int[] dp = new int[K + 1];
        int MAX = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            for (int j = W; j <= K; j++) {
                if (dp[j] + V > dp[j - W]) {
                    dp[j - W] = dp[j] + V;
                    MAX = Math.max(dp[j - W], MAX);
                }
            }
        }
        System.out.println(MAX);

    }
}