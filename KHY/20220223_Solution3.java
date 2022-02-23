import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w, h, res, map[][];
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer stn = new StringTokenizer(br.readLine());
			w = Integer.parseInt(stn.nextToken()); // 열
			h = Integer.parseInt(stn.nextToken()); // 행
			// 탈출 조건
			if(w == 0 && h == 0) break;
			map = new int[h][w]; // 섬 지도
			visited = new boolean[h][w];
			res = 0;
			// 섬 지도 입력
 			for (int i = 0; i < h; i++) {
				stn = new StringTokenizer(br.readLine());
 				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(stn.nextToken());
				}
			}
 			for (int i = 0; i < h; i++) {
 				for (int j = 0; j < w; j++) {
 					if(!visited[i][j] && map[i][j] == 1) {
 						dfs(i,j);
 						res++;
 					}
 				}
 			}
			System.out.println(res);
		}
	}
	public static void dfs(int r, int c) {
		// 방문안했던 곳이고 1이 나왔으면
		visited[r][c] = true;
		//8방위 탐색
		// 우
		if(c+1 < w && !visited[r][c+1] && map[r][c+1] == 1) {
			dfs(r, c+1);
		}
		// 우하
		if(r+1 < h && c+1 < w && !visited[r+1][c+1] && map[r+1][c+1] == 1) {
			dfs(r+1, c+1);
		}
		// 하
		if(r+1 < h && !visited[r+1][c] && map[r+1][c] == 1) {
			dfs(r+1, c);
		}
		// 좌하
		if(r+1 < h && c-1 >= 0 && !visited[r+1][c-1] && map[r+1][c-1] == 1) {
			dfs(r+1, c-1);
		}
		// 좌
		if(c-1 >= 0 && !visited[r][c-1] && map[r][c-1] == 1) {
			dfs(r, c-1);
		}
		// 좌상
		if(r-1 >= 0 && c-1 >= 0 && !visited[r-1][c-1] && map[r-1][c-1] == 1) {
			dfs(r-1, c-1);
		}
		// 상
		if(r-1 >= 0 && !visited[r-1][c] && map[r-1][c] == 1) {
			dfs(r-1, c);
		}
		// 우상
		if(r-1 >= 0 && c+1 < w && !visited[r-1][c+1] && map[r-1][c+1] == 1) {
			dfs(r-1, c+1);
		}
	}
}