package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 
 * @author us13579
 * @since 2022-02-14, 1시간10분
 * @title 백설 공주와 일곱 난쟁이, 브론즈2
 */

public class BOJ_3040 {
	static int[] arr;
	// 7개 뽑기
	static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 일곱 난쟁이 배열
		arr = new int[9];
		num = new int[7];

		// 입력
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dfs(0, 0);

	}

	// 조합
	static void dfs(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			// sum 구하기
			for (int i = 0; i < num.length; i++) {
				sum += num[i];
			}
			if (sum == 100) {
				for (int i = 0; i < num.length; i++) {
					System.out.println(num[i]);
				}
				return;
			}
			return;
		}

		// 다음 것 부터 쭈욱
		for (int i = start; i < arr.length; i++) {
			num[cnt] = arr[i];
			dfs(cnt + 1, i + 1);
		}

	}
}
