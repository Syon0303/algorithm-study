import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		// 우, 우하, 하, 좌하, 좌, 좌상, 상, 우상
		int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
		int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer stn = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = stn.nextToken().charAt(0);
				}
			}
			// 저수지 깊이 찾기
			int max = 1;
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					int res = 0;
					// 8방위 탐색
					for (int k = 0; k < 8; k++) {
						if(map[i+dy[k]][j+dx[k]]=='W') {
							res++;
						}
					}
					max = Math.max(res, max);
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}