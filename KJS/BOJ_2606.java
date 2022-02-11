package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 
 * @author us13579
 * @since 2022-02-10, 30분
 * @title 바이러스, 실버3
 */

public class BOJ_2606 {
	static StringTokenizer st;
	static int[][] arr;
	static boolean[] isChecked;
	static int N;
	// 출력할 컴퓨터 수
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 컴퓨터 수
		int N = Integer.parseInt(br.readLine());

		// 컴퓨터 쌍의 수
		int cp = Integer.parseInt(br.readLine());

		// 컴퓨터 쌍 연결 상태 배열 1-> 연결 o , 0-> 연결 x
		arr = new int[N][N];

		// 감염 유무
		isChecked = new boolean[N];

		for (int i = 0; i < cp; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			// 순서 상관 x
			arr[first - 1][second - 1] = 1;
			arr[second - 1][first - 1] = 1;
		}

		// 감염 체크
		dfs(0);

		// 출력
		sb.append(cnt);
		System.out.println(cnt);
	}

	// 감염 체크
	static void dfs(int current) {
		// 기저조건
		if(current == arr.length) {
			return;
		}
		// 처음 시작하는 컴퓨터는 바이러스에 감염되어있음
		isChecked[current] = true;
		
		for (int i = 0; i < arr.length; i++) { 
			// 다음 것이 false ( 감염 안되어 있고 ), i 가 현재 값이 아니고 , 간선이 연결되어 있다면 추가
			if (!isChecked[i] && i != current && arr[current][i] == 1) { 
				cnt++;
				// 계속 간선 따라서 들어가서 파악한다
				dfs(i);
			}
		}
	}
}