package day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다리 놓기
public class BOJ_1010 {
	
	static int[][] map = new int[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			// n개중에 r개를 순서 없이 뽑는거니까 nCr 이다.
			sb.append(comb(n, r) + "\n");
		}
		
		System.out.println(sb);
	}
	static int comb(int n, int r) {
		// 이미 값이 있을 경우 반환
		if(map[n][r] > 0) return map[n][r];
		
		// nC0 = nCn = 1
		if(n==r || r==0) {
			map[n][r] = 1;
			return 1;
		}
		
		// n+1 C r+1 = n C r + n C r+1
		return map[n][r] = comb(n-1, r-1) + comb(n-1, r);
	}
}
	