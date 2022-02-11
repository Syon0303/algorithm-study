package day7;

import java.util.Scanner;

// 배열 돌리기 1
public class BOJ_16926 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

		// 배열 입력
		int[][] map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}



		// 우 0, 하 1, 좌 2, 상 3
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};

		// 회전 시켜야 하는 줄이 몇 줄인가?
		int turnCnt = Math.min(N, M)/2;

		// 회전
		while(R-->0) {
			for(int i=0; i<turnCnt; i++) {
				int idx = 0;
				
				// 내 위치
				int x = i;
				int y = i;				
				
				// 첫 번째 수 미리 빼놓음
				int temp = map[x][y];
				
				// 딱 한 바퀴만 도니까 4번 (%연산 불필요)
				while(idx<4) {
					// 내가 갈 위치
					int nx = x + dx[idx];
					int ny = y + dy[idx];
					
					// 벽에 부딪히지 않으면 계속
					if(nx>=i && ny>=i && nx<N-i && ny<M-i) {
						map[x][y] = map[nx][ny];
						x = nx;
						y = ny;
					}
					// 벽에 부딪히면 방향 전환
					else {
						idx++;
					}
				}
				map[i+1][i] = temp;


			}

		}
		
		for(int[] i: map) {
			for(int j: i) {
				System.out.print(j + " ");
			}System.out.println();
		}
	}

}
