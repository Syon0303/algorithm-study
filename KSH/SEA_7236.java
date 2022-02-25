package day17;

import java.util.Scanner;

// 저수지의 물의 총 깊이 구하기, D3, 30분
public class SEA_7236 {

	// 좌상부터 시계방향
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int N;
	static int res;
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			N = sc.nextInt();
			map = new char[N][N];
			for(int i=0; i<N; i++) for(int j=0; j<N; j++) map[i][j] = sc.next().charAt(0);
			res = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 'W') search(i, j);
				}
			}
			System.out.println("#" + test_case + " " + res);

		}
	}
	
	public static void search(int x, int y) {
		int sum = 0;
		
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(map[nx][ny] == 'W') sum++;
			}
		}
		if(sum==0) sum = 1;
		res = Math.max(sum, res);
	}
}
