import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		System.out.println(dfs(N));
	}
	public static int dfs(int cnt) {
		// 초기 탈출 조건
		if(cnt == 1) return 1;
		if(cnt == 2) return 2;
		//dp에 값이 있으면 그 값 return
		if(dp[cnt] != 0) return dp[cnt];
		// dp에 저장과 동시에 해당 값 return
		return dp[cnt] = (dfs(cnt-1) + dfs(cnt-2)) % 15746;
	}
}
