import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stn.nextToken());
		int r = Integer.parseInt(stn.nextToken());
		int c = Integer.parseInt(stn.nextToken());
		dfs(N, r, c);
		System.out.println(res);
	}
	
	public static void dfs(int cnt, int r, int c) {
		if(cnt == 1) {
			if(r == 0 && c == 1) {
				res += 1;
			}else if(r == 1 && c == 0) {
				res += 2;
			}else if(r == 1 && c == 1) {
				res += 3;
			}
			return;
		}
		int half = (int)Math.pow(2,cnt) / 2;
		int by = 0;
		// 행이 절반보다 작으면 1,2분면에 존재
		if(r < half) {
			// 열이 절반보다 크거나 같으면 2분면
			if(c >= half) {
				c -= half;
				by = 1;
			}
		// 그 외 3, 4분면에 존재
		}else {
			r -= half;
			// 3분면
			if(c < half) {
				by = 2;
			// 4분면
			}else {
				c -= half;
				by = 3;
			}
		}
		res = (int) (res + (by * Math.pow(2, cnt-1) * Math.pow(2, cnt-1)));
		dfs(cnt-1, r, c);
	}
}