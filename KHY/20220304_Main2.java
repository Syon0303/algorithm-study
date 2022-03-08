import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp, map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N][3];
		map = new int[N][3];
		StringTokenizer stn = null;
		for (int i = 0; i < N; i++) {
			stn = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(stn.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			dp[0][i] = map[0][i];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				//빨간색으로 가는 경로 ( 초->빨, 파->빨) 중 작은것
				dp[i][j] = Math.min(dp[i-1][(j+1)%3]+map[i][j],dp[i-1][(j+2)%3]+map[i][j]);
			}
		}
		System.out.println(Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2])));
	}
}
