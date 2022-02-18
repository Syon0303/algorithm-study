package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-02-13, 1시간 10분
 * @title 배열돌리기 3, 실버1
 */
public class BOJ_16935 {
	static StringTokenizer st;
	static int N, M, R;
	// 배열 입력
	static int[][] arr;
	// 배열 출력
	static int[][] arr_res;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		num = new int[R];

		// 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 연산 입력
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		// R 만큼 연산 수행
		for (int i = 0; i < R; i++) {
			switch (num[i]) {

			// 상하 반전
			case 1:
				one();
				break;

			// 좌우 반전
			case 2:
				two();
				break;

			// 오른쪽 90도 회전
			case 3:
				three();
				break;

			// 왼쪽 90도 회전
			case 4:
				four();
				break;

			// 부분 배열 나누고 4개의 그룹으로 나누기, 1->2, 2->3, 3->4, 4->1
			case 5:
				five();
				break;

			// 부분 배열 나누고 4개의 그룹으로 나누기, 1->4, 4->3, 3->2, 2->1
			case 6:
				six();
				break;
				
			}
		}
		show();
	}

	// 상하 반전
	static void one() {
		arr_res = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr_res[i][j] = arr[N - (i + 1)][j];
			}
		}
		init();
	}

	// 좌우 반전
	static void two() {
		arr_res = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr_res[i][j] = arr[i][M - (j + 1)];
			}
		}
		init();
	}

	// 오른쪽 90도 회전
	static void three() {
		arr_res = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr_res[j][N - 1 - i] = arr[i][j];
			}
		}
		init();
	}

	// 왼쪽 90도 회전
	static void four() {
		arr_res = new int[M][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr_res[M - 1 - j][i] = arr[i][j];
			}
		}
		init();
	}

	// 부분 배열 나누고 4개의 그룹으로 나누기, 1->2, 2->3, 3->4, 4->1
	static void five() {
		arr_res = new int[N][M];

				// 1 그룹 -> 2 그룹
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M / 2; j++) {
						arr_res[i][M / 2 + j] = arr[i][j];
					}
				}
				// 2 그룹 -> 3 그룹
				for (int i = 0; i < N / 2; i++) {
					for (int j = M / 2; j < M; j++) {
						arr_res[i + N / 2][j] = arr[i][j];
					}
				}

				// 3 그룹 -> 4 그룹
				for (int i = N / 2; i < N; i++) {
					for (int j = M / 2; j < M; j++) {
						arr_res[i][j - M / 2] = arr[i][j];
					}
				}

				// 4 그룹 -> 1 그룹
				for (int i = N / 2; i < N; i++) {
					for (int j = 0; j < M / 2; j++) {
						arr_res[i - N / 2][j] = arr[i][j];
					}
				}
				
		init();
	}

	// 부분 배열 나누고 4개의 그룹으로 나누기, 1->4, 4->3, 3->2, 2->1
	static void six() {
		arr_res = new int[N][M];

		// 1 그룹 -> 4 그룹
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				arr_res[i + N / 2][j] = arr[i][j];
			}
		}

		// 4 그룹 -> 3 그룹
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				arr_res[i][j + M / 2] = arr[i][j];
			}
		}

		// 3 그룹 -> 2 그룹
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				arr_res[i - N / 2][j] = arr[i][j];
			}
		}

		// 2 그룹 -> 1 그룹
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				arr_res[i][j - M / 2] = arr[i][j];
			}
		}
		init();
	}

	// 배열 출력 
	static void show() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}


	// arr 누적 관리
	static void init() {
		// 만약 3,4 번을 했다면
		if (arr_res.length != N && arr_res[0].length != M) {
			int temp = N;
			N = M;
			M = temp;
			arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = arr_res[i][j];
				}
			}
			
		} 
		else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = arr_res[i][j];
				}
			}
		}
	}
}
