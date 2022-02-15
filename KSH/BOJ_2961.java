package day8;

import java.util.Scanner;

public class BOJ_2961 {

	static boolean[] v; // 재료를 사용했는지 안했는지 체크하는 배열
	static int[][] material; // 재료 배열
	static int N; // 재료 몇 개?
	static int res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		material = new int[N][2];
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				material[i][j] = sc.nextInt();
			}
		}
		
		v = new boolean[N];
		res = 99999;
		
		dfs(0);
		System.out.println(res);
	}
	
	static void dfs(int cnt) {
		// 만약 모든 재료를 다 봤다면
		if(cnt == N) {
			int sour = 1; // 신맛은 곱해야 하니까 1부터
			int bitter = 0; // 쓴맛은 더해야 하니까 0부터
			int idx = 0;
			
			for(int i=0; i<N; i++) {
				if(v[i]) {
					idx++;
					sour *= material[i][0];
					bitter += material[i][1];
				}
			}
			// 부분집합의 합이므로 공집합 예외처리
			if(idx == 0) return;
			
			// 만약 현재 res가 두 값의 차보다 크다면 두 값의 차를 res에 넣어라(단, 절대값 필요)
			if(res > Math.abs(sour - bitter)) res = Math.abs(sour - bitter);
			
			return;
		}
		
		
		// 이 재료를 선택함
		v[cnt] = true;
		dfs(cnt+1);
		
		// 이 재료를 선택하지 않음
		v[cnt] = false;
		dfs(cnt+1);
		
	}
	
}
