package day15;

import java.util.Scanner;

// 섬의 개수, 실버 2, 40분 (w랑 h를 헷갈려서 헤맸다)
public class BOJ_4963 {

	static int w, h;
	static int[][] map;
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static boolean[][] v;
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			h = sc.nextInt();
			w = sc.nextInt();
			if(w==0 && h==0) break;
			map = new int[w][h];
			for(int i=0; i<w; i++) for(int j=0; j<h; j++) map[i][j] = sc.nextInt();
			v = new boolean[w][h];
			res = 0;
			
			for(int i=0; i<w; i++) {
				for(int j=0; j<h; j++) {
					// 육지이면서 내가 가보지 않은 곳이라면
					if(map[i][j] == 1 && !v[i][j]) {
						search(i,j);
						res++;
					}
				}
			}
			System.out.println(res);
		}
	}

	public static void search(int x, int y) {
		v[x][y] = true;
		for(int i=0; i<8; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			// 다음 갈 범위가 맵 안쪽인가?
			if(nextX>=0 && nextX<w && nextY>=0 && nextY<h) {
				// 다음 갈 범위가 육지이면서 가보지 않은 곳인가?
				if(map[nextX][nextY]==1 && !v[nextX][nextY]) {
					search(nextX, nextY);
				}
			}
		}
	}
}
