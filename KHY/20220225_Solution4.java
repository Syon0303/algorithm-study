import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Vertex{
		int x;
		int y;
		int depth;
		public Vertex(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}		
	}
	static int M, N, total, cnt, box[][];
	static boolean visited[][];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stn = new StringTokenizer(br.readLine());
		M = Integer.parseInt(stn.nextToken());
		N = Integer.parseInt(stn.nextToken());
		box = new int[N][M];
		visited = new boolean[N][M];
 		Queue<Vertex> queue = new LinkedList<Vertex>();
		total = 0; cnt = 0;
		for (int i = 0; i < N; i++) {
			stn = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(stn.nextToken());
				if(box[i][j] == 1 || box[i][j] == 0 ) {
					total++; // 토마토 전체 개수 체크
					// 익은 토마토면
					if(box[i][j] == 1) {
						queue.offer(new Vertex(j, i, 0)); // 큐에 추가
						visited[i][j] = true;
						cnt++; // 현재 익은 토마토 개수 증가
					}
				}
			}
		}
		// 첫 맵에 1이 없으면 끝
		if(queue.isEmpty()) {
			System.out.println(-1);
		}else {
			bfs(queue);
		}
	}
	public static void bfs(Queue<Vertex> queue) {
		Queue<Vertex> next = new LinkedList<Vertex>();
		int depth = queue.peek().depth; // 토마토 깊이 값 임시로 저장해두기
		// 같은 깊이 끝날 때까지 (동일한 날) 
		while(!queue.isEmpty()) {
			Vertex temp = queue.poll();
			// 4방위 탐색 (우 하 좌 상)
			for (int k = 0; k < 4; k++) {
				int y = temp.y+dy[k];
				int x = temp.x+dx[k];
				// 이미 방문했던 곳이면 패스
				if(y >= 0 && y < N && x >=0 && x < M && visited[y][x]) continue;
				// 안익은 토마토가 근처에 있으면
				if(y >= 0 && y < N && x >=0 && x < M && box[y][x] == 0) {
					next.offer(new Vertex(x, y, temp.depth+1)); // 다음 큐에 넣고
					visited[y][x] = true; // 방문체크하고
					cnt++; // 현재 익은 토마토 개수 증가
				}
			}
		}
		if(next.isEmpty()) {
			// 현재 익은 토마토개수와 전체 토마토 개수가 다를 경우
			if(cnt != total) {
				System.out.println(-1);
			// 같은 경우
			}else {
				System.out.println(depth);
			}
			return;
		}
		bfs(next);
	}
}