import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] dp = new int[N+1][K + 1];
		int wv[][] = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			wv[i][0] = sc.nextInt();
			wv[i][1] = sc.nextInt();

		}
		for (int i = 1; i <= N; i++) {
			for(int j=0;j<=K;j++) {
				if (wv[i][0] > j)
					dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = Math.max(dp[i-1][j],wv[i][1]+dp[i-1][j-wv[i][0]] );
				}
			}
			
		}

		System.out.println(dp[N][K]);

	}

}