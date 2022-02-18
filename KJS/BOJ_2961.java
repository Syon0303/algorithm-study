package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author us13579
 * @since 2022-02-14, 35분
 * @title 도영이가 만든 맛있는 음식, 실버1
 */

public class BOJ_2961 {
	static StringTokenizer st;
	// 부분집합 합에서 체크
	static boolean[] isChecked;
	// 신맛, 쓴맛 배열
	static int[] S, B;
	// 재료의 개수
	static int N;
	static int res = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 재료의 개수
		N = Integer.parseInt(br.readLine());

		// 신맛 배열
		S = new int[N];
		// 쓴맛 배열
		B = new int[N];

		// 부분집합 합에서 체크
		isChecked = new boolean[N];

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 재료의 신맛 S -> *
			S[i] = Integer.parseInt(st.nextToken());
			// 재료의 쓴맛 B -> +
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		go(0);
		
		sb.append(res);
		System.out.println(sb);

	}

	// 부분집합 합
	static void go(int start) {
		int S_sum = 1;
		int B_sum = 0;
		int cnt =0;
		// 기저조건
		if (start == N) {
			// true 면 계산을 한다
			for (int i = 0; i < N; i++) {
				if (isChecked[i]) {
					cnt++;
					S_sum *= S[i];
					B_sum += B[i];
				}
			}
			// 공집합이면 return
			if(cnt == 0) {
				return;
			}
			if(res > Math.abs(S_sum - B_sum)) {
				res = Math.abs(S_sum - B_sum);
			}
			return;
		}

		isChecked[start] = true;
		go(start + 1);

		isChecked[start] = false;
		go(start + 1);

	}

}
