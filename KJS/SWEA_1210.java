package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author us13579
 * @since 2022-02-09, 1시간
 * @title Ladder1, (D4)
 */

public class SWEA_1210 {
	static int N = 100;
	static int des_x, des_y;
	
	// 3방향
	static int[] dx = { 1, -1, 0 };
	static int[] dy = { 0, 0, -1 };


	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			sb.append("#").append(t).append(" ");

			// 입력에 1,2,3.. 들어가있다
			int num = Integer.parseInt(br.readLine());

			
			int[][] arr = new int[N][N];
			// 방문했는지 확인하는 boolean 배열 - 방문했으면 true 안했으면 false
			boolean[][] isChecked = new boolean[N][N];

			// 배열 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					
					// 도착지의 x,y 좌표 저장
					if (arr[i][j] == 2) {
						des_x = j;
						des_y = i;
					}
				}
			}
			
			// 밑에서 부터 시작
			int nx = N;
			int ny = N;

			while(ny != 0) {
				// 위 오 왼 만 확인하면 됨
				for(int i=0;i<3;i++) {
					nx = des_x + dx[i];
					ny = des_y + dy[i];
					
					if(!(nx<N && nx >=0 && ny<N && ny>=0)) {
						continue;
					}
					// 다음 좌표의 숫자가 1이고 boolean 배열이 false이면 ( 아직 안갔다는 말 )
					if(arr[ny][nx] == 1 && !isChecked[ny][nx]) {
						des_x = nx;
						des_y = ny;
						isChecked[des_y][des_x] = true;
						
						// 이미 갔기 때문에 이 for문은 break
						break;
					}
				}
			}
			sb.append(nx).append("\n");
		}
		System.out.println(sb);
	}
}
