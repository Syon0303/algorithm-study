package day11;

import java.util.Scanner;

// 알파벳 골드4 1시간 20분
public class BOJ_1987 {

	static int R, C;
	static char[][] map;
	static boolean[] v = new boolean[26];
	static int[] x = {-1, 1, 0, 0};
	static int[] y = {0, 0, -1, 1};
	//static int cnt;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			char[] temp = sc.next().toCharArray();
			for(int j=0; j<C; j++) {
				map[i][j] = temp[j];
			}
		}
		
//		cnt = 0;
		dfs(0, 0, 0);
		System.out.println(max);
	}
	
	static void dfs(int r, int c, int cnt) {
//		System.out.print("지금 보는 곳 : " + r + " " + c);
		if(r<0 || r>=R || c<0 || c>=C || v[(int)map[r][c]-65]) {
//			System.out.println();
			return;
		}
		
		cnt++;
//		System.out.println("늘어난 후 max" + max);
		v[(int)map[r][c]-65] = true;
		max = Math.max(max, cnt);
		
		for(int i=0; i<4; i++) dfs(r+x[i], c+y[i], cnt);
		
		v[(int)map[r][c]-65] = false;
	}
}
