package day17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 토마토, 골드 5, 교수님 코드
public class BOJ_7576_P {

	static int[][] map;
	static int N, M;
	static Queue<Data> queue = new LinkedList<>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int res = -1;
	
	static class Data{
		int x, y;

		public Data(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Data [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				// 토마토가 있으면 숙성할 수 있음
				if(map[i][j]==1) queue.offer(new Data(j,i));
			}
		}
		bfs();
		System.out.println(res);
	}
	
	public static void bfs() {
		// 방문체크 배열 필요 없음. 자체 맵 자료를 방문체크로 활용. 0이면 방문해야 하고, 그 외 나머지는 가본 곳이거나 -1은 갈 수 없는 곳.
		// 같은 단위별로 확장.
		// size 만큼만 돌아야함.
		int size = 0;
		int depth = 0;
		Data current;
		while(!queue.isEmpty()) {
			size = queue.size();
			for(int i=0; i<size; i++) {
				current = queue.poll();
				// 4방위로 주변 익히기
				for(int d=0; d<4; d++) {
					int nx = current.x + dx[d];
					int ny = current.y + dy[d];
					// 배열 범위 체크
					if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
					// 이동 여부 판단
					if(map[ny][nx] != 0) continue; 
					// 이동 가능하면 큐에 삽입
					queue.offer(new Data(nx, ny));
					map[ny][nx] = map[current.y][current.x] + 1; 
				}
			}
			depth++; // 지금 이건 의미없긴함 ㅋㅋ;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					res = -1;
					return;
				}
				if(map[i][j] == -1) continue;
				
				res = Math.max(res, map[i][j]);
			}
		}
		res--;
	}


}
