package day12;

import java.util.Scanner;

/*
 * 빵집, 골드2
 * dfs의 반환타입을 boolean으로 하는 것을 생각 못하고 계속 답이 4가 나와서 삽질함.
 */
public class BOJ_3109 {


	static boolean[][] v;
	static int R;
	static int C;
	static int cnt;
	static String[][] map;
	static int[] dr = {-1, 0, 1}; // 행의 움직임

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		cnt = 0;

		map = new String[R][C];
		for(int i=0; i<R; i++) {
			String[] temp = sc.next().split("");
			for(int j=0; j<C; j++) {
				map[i][j] = temp[j];
			}
		}

		v = new boolean[R][C];
		for(int i=0; i<R; i++) {
			v[i][0] = true;
			dfs(i, 0);
		}
		System.out.println(cnt);
	}

	public static boolean dfs(int r, int c) {
		// 만약 마지막 열(내 빵집)까지 내가 가려는 곳에 도달했다면 끝낸다.
		if(c == C-1) {
			cnt++;
			return true;
		}

		int myr;
		int myc = c+1;
		
		// 우상, 우, 우하 일단 이동한다.
		for(int i=0; i<3; i++) {
			// 가려고 하는 행(myr)은 원래 행 + 가려고 하는 곳
			myr = r+dr[i];
			// 만약 내가 가려고 하는 행이 꼭대기 또는 바닥을 넘는다면 다음 방향으로 넘어간다.
			if(myr < 0 || myr >= R) continue;
			// 만약 가려고 하는 곳이 X이거나, 설치 했던 곳이면 다음 방향으로 넘어간다.
			if(map[myr][myc].equals("x") || v[myr][myc]) continue;
			// 파이프를 설치하자.
			v[myr][myc] = true;
			// 다음 파이프 설치하러 가자.
			if(dfs(myr, myc)) return true;
		}
		return false;
	}
}
