import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author us13579
 * @since 2022-02-07
 * @title 햄버거 다이어트
 * 
 */

public class D3_5215 {
	static int N, L;
	static int[] cal, score;
	static int res;
	static boolean[] isChecked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int TC = Integer.parseInt(st.nextToken());

		for (int T = 1; T <= TC; T++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N];
			cal = new int[N];
			isChecked = new boolean[N];

			// Test Case 값 입력
			for (int TT = 0; TT < N; TT++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				score[TT] = c;
				cal[TT] = s;
			}

			// 부분집합 계산 go()
			res = 0;
			go(0);

			sb.append("#").append(T).append(" ").append(res);
			System.out.println(sb);

		}
	}

	public static void go(int idx) {
		if (idx == N) {

			int cal_sum = 0;
			int score_sum = 0;

			for (int i = 0; i < N; i++) {
				if (isChecked[i]) {
					cal_sum += cal[i];
					score_sum += score[i];
				}
			}

			if (cal_sum < L && score_sum > res) {
				res = score_sum;
			}

			return;
		}

		isChecked[idx] = true;
		go(idx + 1);

		isChecked[idx] = false;
		go(idx + 1);
	}
}
