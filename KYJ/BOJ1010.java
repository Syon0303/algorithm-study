import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1010 {
	public static int combinations[][] = new int[30][30];
	
	public static int combination(int n, int r) {
		if(combinations[n][r] > 0) return combinations[n][r]; 
		
		// 조합 성질 1
		// nC0 = nCn == 1
		if(n == r || r == 0) {
			combinations[n][r] = 1;
			return 1;
		}
		
		// 조합 성질 2
		// nCr = nCn-r
		if(combinations[n][n-r] > 0) {
			combinations[n][r] = combinations[n][n-r];
			return combinations[n][r];
		}
		
		// 조합 성질 3
		// n+1Cr+1 = nCr + nCr+1
		// nCr = n-1Cr-1 + n-1Cr
		return combinations[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			sb.append(combination(n, r)+"\n");
		}
		System.out.println(sb.toString());
	}
}
