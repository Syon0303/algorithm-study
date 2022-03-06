import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stn.nextToken());
		int k = Integer.parseInt(stn.nextToken());
		int[] w = new int[n];
		int[] v = new int[n];
		int[][] dp = new int[n+1][k+1];
		int max = 0;
		for(int i = 0; i < n; i++) {
			stn = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(stn.nextToken());
			v[i] = Integer.parseInt(stn.nextToken());
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= k; j++) {
				if(w[i-1] <= j)
					dp[i][j] = Math.max(v[i-1] + dp[i-1][j - w[i-1]], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
				max = Math.max(dp[i][j], max);
			}
		}
		System.out.println(max);
	}
}
