package day10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 스터디
 * 블랙잭, 브론즈 2
 */
public class BOJ_2798 {

	static int[] map;
	static int N, M;
	static int res;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String temp = br.readLine();
		
		N = Integer.parseInt(temp.split(" ")[0]);
		M = Integer.parseInt(temp.split(" ")[1]);
		
		map = new int[N];
		temp = br.readLine();
		for(int i=0; i<N; i++) map[i] = Integer.parseInt(temp.split(" ")[i]);
		
//		v = new boolean[N];
//		dfs(0, 0);
		
		res = 0;
		comb(0, 0, 0);
		System.out.println(res);
	}
	
	static void comb(int cnt, int start, int sum) {
		if(cnt==3) {
			if(sum <= M) {
				res = Math.max(res, sum);
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			comb(cnt+1, i+1, sum+map[i]);
		}
	}
	
	
	/* 부분집합의 합 코드. 시간 초과가 뜬다.
	static boolean[] v;
	
	public static void dfs(int cnt, int sum) {
		if(res==M) return;
		if(cnt==N) { // 끝까지 다 보고
			int temp = 0;
			for(int i=0; i<N; i++) if(v[i]) temp++;
			if(temp==3) { // 3개를 뽑는 경우에서
				if(sum<=M) { // sum이 M을 넘지 않는 경우에
					res = Math.max(res, sum);
				} return;
			} return;
		}
		
		v[cnt] = true;
		dfs(cnt+1, sum+map[cnt]);
		v[cnt] = false;
		dfs(cnt+1, sum);
	}
	*/
}
