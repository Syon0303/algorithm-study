import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N, M, R;	// 배열의 크기 N, M, 수행해야 하는 회전의 수 R
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		int arr[][] = new int[N][M];	// 회전시킬 배열
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int iteration = (Math.min(N, M)%2 == 0) ? Math.min(N, M)/2 : Math.min(N, M)%2+1; // 껍데기 수
		int x, y, flag = 1;
		int prev, temp;
		
		for(int r = 0; r < R; r++) { // R만큼 rotate
			for(int i = 0; i < iteration; i++) {
				x = i;
				y = i;
				prev = arr[x][y]; // i번째 껍데기 출발 점
				for(int j = 0; j < 2; j++) { // 하 -> 우 -> 상 -> 좌
					// 하 or 상
					for(int k = 0; k < N - i*2 - 1; k++) {
						y += flag;
						temp = arr[y][x];
						arr[y][x] = prev;
						prev = temp;
					}
					// 우 or 좌
					for(int k = 0; k < M - i*2 - 1; k++) {
						x += flag;
						temp = arr[y][x];
						arr[y][x] = prev;
						prev = temp;
					}
					flag *= -1;
				}
			}
		}
		
		// result
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}