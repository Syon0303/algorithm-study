import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, res = 0;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		// 색맹 아닌 사람들이 보이는 그림 = map
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray(); 
		}
		visited = new boolean[N][N]; // 방문 체크
		// 색에 따라 영역 구분하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					switch (map[i][j]) {
					case 'R':
						dfs(map, 'R', i, j);
						res++;
						break;
					case 'G':
						dfs(map, 'G', i, j);
						res++;
						break;
					case 'B':
						dfs(map, 'B', i, j);
						res++;
						break;
					}
				}
			}
		}
		System.out.print(res+" ");
		char[][] map2 = new char[N][N];
		// 색맹인 사람이 보이는 그림 (G를 R로 바꾸기)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'G') {
					map2[i][j] = 'R';
				}else {
					map2[i][j] = map[i][j];
				}
			}
		}
		visited = new boolean[N][N];
		res = 0;
		// 영역 구분
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					switch (map2[i][j]) {
					case 'R':
						dfs(map2, 'R', i, j);
						res++;
						break;
					case 'B':
						dfs(map2, 'B', i, j);
						res++;
						break;
					}
				}
			}
		}
		System.out.println(res);
	}
	public static void dfs(char[][] map, char color, int r, int c) {
		visited[r][c] = true;
		// 상, 우, 하, 좌
		int[] dx = {0, 1, 0, -1}; 
		int[] dy = {-1, 0, 1, 0};
		
		//찾은 색 기준 8방위 탐색
		for (int i = 0; i < 4; i++) {
			int x = c + dx[i];
			int y = r + dy[i];
			if(x >=0 && x < N && y >= 0 && y < N && !visited[y][x]) {
				if(map[y][x] == color) {
					dfs(map, color, y, x);
				}
			}
		}
	}
}