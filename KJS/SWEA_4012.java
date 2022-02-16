package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class SWEA_4012 {
	static StringTokenizer st;
	static int[][] arr;
	static boolean[] visited;
	static int N;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 수
		int tc = Integer.parseInt(br.readLine());

		for (int T = 1; T <= tc; T++) {
			sb.append("#").append(T).append(" ");
			// 최솟값 구할거라 처음엔 최댓값 설정
			min = Integer.MAX_VALUE;

			// N 개수
			N = Integer.parseInt(br.readLine());

			// 맛 배열
			arr = new int[N][N];
			// 사용한 유무
			visited = new boolean[N];
			

			// 배열 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			
			combination(0,0);
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	// 조합 계산
	static void combination(int cnt, int start) {
		if (cnt == N / 2) {
			check();
			return;
		}

		for (int i = start; i < N; i++) {
			visited[i] = true;
			combination(cnt + 1, i + 1);
			visited[i] = false;
		}
	}
		
	static void check() {
		int A_sum = 0;
		int B_sum = 0;
		
		// 사용된 것끼리, 사용 안된 것 끼리
		for(int i=0; i<N-1; i++) {
			for(int j = i+1; j<N; j++) {
				if(visited[i] && visited[j]) {
					A_sum += (arr[i][j]+arr[j][i]);
				}
				else if(!visited[i] && !visited[j]) {
					B_sum += (arr[i][j]+arr[j][i]);
				}
			}
		}
		
		min = Math.min(Math.abs(A_sum-B_sum), min);
		
	}
}
