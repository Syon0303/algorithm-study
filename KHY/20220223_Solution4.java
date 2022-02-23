import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, a, b, map[][];
	static boolean flag, visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		StringTokenizer stn = new StringTokenizer(br.readLine());
		a = Integer.parseInt(stn.nextToken());
		b = Integer.parseInt(stn.nextToken());
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			stn = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stn.nextToken());
			int to = Integer.parseInt(stn.nextToken());
			map[from][to]++;
			map[to][from]++;
		}
		dfs(a, 0);
	}
	private static void dfs(int cnt, int res) {
		visited[cnt] = true;
		for (int i = 1; i <= n; i++) {
			if(!visited[i] && map[cnt][i] == 1) {
				res++;
				if(i == b) {
					flag = true;
					System.out.println(res);
					return;
				}
				if(flag) return;
 				dfs(i, res);
 				res--;
			}
		}
		if(!flag && cnt == a) System.out.println(-1);
	}
}