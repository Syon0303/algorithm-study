package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-02-11, 1시간
 * @title 다리 놓기, 실버 5
 */

public class BOJ_1010 {
	static StringTokenizer st;
	static int L, R;
	// 동적 계획법
	static int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 입력
		int TC = Integer.parseInt(br.readLine());

		for (int t = 0; t < TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 왼쪽 사이트 수
			L = Integer.parseInt(st.nextToken());

			// 오른쪽 사이트 수
			R = Integer.parseInt(st.nextToken());
			
			//출력
			sb.append(combination(R, L)).append("\n");
		}
		System.out.println(sb);
	}
	
	// nCr 계산
	static int combination(int n, int r) {
		
		// 이미 풀었던 것일 경우 재활용
		if(dp[n][r]>0) {
			return dp[n][r];
		}
		
		// 기저조건
		if(r == 0 || n == r) {
			return dp[n][r] = 1;
		}
		
		// 재귀 돌리면서 값 메모이제이션 , 
		// R , L 에서 시작하기 때문에 - 사용
		return dp[n][r] = combination(n-1, r-1) + combination(n-1, r);
	}
}
