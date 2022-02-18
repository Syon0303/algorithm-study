package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-02-11, 50분
 * @title 배열 돌리기 1, 실버 2
 */
public class BOJ_16926 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");

		// 행의 수
		int N = Integer.parseInt(st.nextToken());
		// 열의 수
		int M = Integer.parseInt(st.nextToken());
		// 회전 수
		int R = Integer.parseInt(st.nextToken());

		// 넣어줄 배열
		int[][] arr = new int[N][M];

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 돌리기
		while (R != 0) {
			// 안에 개수
			for (int z = 0; z < (Math.min(N, M) / 2); z++) {
				// 하나 빼주는 수 
				int first = arr[z][z];
				// 위에
				for (int i = 0 + z; i < M - 1 - z; i++) {
					arr[0 + z][i] = arr[0 + z][i + 1];
				}
				// 오른쪽
				for (int i = 0 + z; i < N - 1 - z; i++) {
					arr[i][M - 1 - z] = arr[i + 1][M - 1 - z];
				}
				// 밑에
				for (int i = M - 1 - z; i > 0 + z; i--) {
					arr[N - 1 - z][i] = arr[N - 1 - z][i - 1];
				}
				// 왼쪽
				for (int i = N - 1 - z; i > 0 + z; i--) {
					arr[i][0 + z] = arr[i - 1][0 + z];
				}
				arr[1 + z][z] = first;
			}
			R--;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}
