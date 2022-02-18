package day8;

import java.util.Scanner;

public class BOJ_3040 {

	static int[] map; // 9 난쟁이
	static boolean[] v; // 고려했는가?

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[9];
		for(int i=0; i<9; i++) map[i] = sc.nextInt();
		v = new boolean[9];
		
		dfs(0, 0);
	}

	static void dfs(int cnt, int idx) {
		// 끝까지 다 봤는데
		if(idx==9) {
			// 난쟁이가 7명이면
			if(cnt==7) {
				int sum = 0;
				// sum 구해라
				for(int i=0; i<9; i++) if(v[i]) sum += map[i];
				
				// 끝까지 다 보고 난쟁이 7명에 sum이 100이면
				if(sum==100) {
					// v[i]에 맞는 map[i] 출력
					for(int i=0; i<9; i++) if(v[i]) System.out.println(map[i]);
					
					// 다하면 꺼라
					System.exit(0);
				}
			}
			return;
		}
		
		v[idx] = true;
		dfs(cnt+1, idx+1);
		v[idx] = false;
		dfs(cnt, idx+1);
	}
}
